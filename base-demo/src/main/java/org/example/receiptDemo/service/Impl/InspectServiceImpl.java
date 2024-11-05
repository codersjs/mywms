package org.example.receiptDemo.service.Impl;

import com.alibaba.fastjson2.JSONObject;
import org.example.o_mysql.domain.TCheckHead;
import org.example.o_mysql.domain.TCheckLine;
import org.example.o_mysql.domain.TReceiptItem;
import org.example.o_mysql.domain.TReceiptLine;
import org.example.o_mysql.service.TCheckHeadService;
import org.example.o_mysql.service.TCheckLineService;
import org.example.o_mysql.service.TReceiptItemService;
import org.example.o_mysql.service.TReceiptLineService;
import org.example.receiptDemo.service.InspectService;
import org.example.utilAndCommonDemo.Enum.EnumReceiptTask;
import org.example.utilAndCommonDemo.Exception.BusinessException;
import org.example.utilAndCommonDemo.unit.IDcreate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class InspectServiceImpl implements InspectService {

    @Resource
    private TReceiptLineService receiptLineService;

    @Resource
    private TReceiptItemService receiptItemService;

    @Resource
    private TCheckHeadService checkHeadService;

    @Resource
    private TCheckLineService checkLineService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void createInspect(String batch,String name, String telephone) {

        if (batch == null || batch.equals("")) {
            throw new BusinessException("批次号不能为空");
        }

        if (name == null || name.equals("负责人不能为空")) {
            name = EnumReceiptTask.INSisNULL.getCode();
        }

        if (telephone == null || telephone.equals("负责人电话不能为空")) {
            telephone = EnumReceiptTask.INSisNULL.getCode();
        }


        TReceiptLine receiptLine = receiptLineService.getById(batch);

        if (receiptLine == null) {
            throw new BusinessException("该批次不存在");
        }
        if (receiptLine.getStatus().equals(EnumReceiptTask.RECFinish)) {
            throw new BusinessException("该订单已经检验完成");
        }
        if (receiptLine.getStatus().equals(EnumReceiptTask.INSOngoing)) {
            throw new BusinessException("该订单已经在检验中");
        }

        List<String> listitem = JSONObject.parseObject(String.valueOf(receiptLine),List.class);
        receiptLine.setStatus(EnumReceiptTask.INSOngoing.getCode());
        receiptLineService.updateById(receiptLine);

        // 创建验收单头
        TCheckHead checkHead = new TCheckHead();
        checkHead.setCheadid(IDcreate.getStringId(8));
        checkHead.setBatchId(receiptLine.getBatchId());
        checkHead.setManagerName(name);
        checkHead.setManagerTelephone(telephone);
        checkHead.setStatus(EnumReceiptTask.INSNotStart.getCode());
        List<String> list = new ArrayList<>();


        for (String x : listitem) {
            TReceiptItem receiptItem = receiptItemService.getById(x);
            receiptItem.setStatus(EnumReceiptTask.INSOngoing.getCode());
            receiptItemService.save(receiptItem);

            // 创建验收单行
            TCheckLine checkLine = new TCheckLine();
            checkLine.setChecklineid(IDcreate.getStringId(8));
            checkLine.setCheadid(checkHead.getCheadid());
            checkLine.setRitemId(x);
            checkLine.setSpuId(receiptItem.getSpuId());
            checkLine.setSpecId(receiptItem.getSpecId());
            checkLine.setItemList(EnumReceiptTask.INSisNULL.getCode());
            checkLine.setOperateName(EnumReceiptTask.INSisNULL.getCode());
            checkLine.setOperateTelephone(EnumReceiptTask.INSisNULL.getCode());
            checkLine.setStatus(EnumReceiptTask.INSNotStart.getCode());
            checkLine.setTotalNum(-1D);
            list.add(checkLine.getCheadid());
            checkLineService.save(checkLine);
        }
        checkHead.setCheckLineList(JSONObject.toJSONString(list));
        checkHeadService.save(checkHead);

    }
}
