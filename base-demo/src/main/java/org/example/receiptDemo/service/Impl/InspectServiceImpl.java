package org.example.receiptDemo.service.Impl;

import com.alibaba.fastjson2.JSONObject;
import org.example.o_mysql.domain.*;
import org.example.o_mysql.service.*;
import org.example.receiptDemo.service.InspectService;
import org.example.utilAndCommonDemo.Enum.EnumGood;
import org.example.utilAndCommonDemo.Enum.EnumReceiptTask;
import org.example.utilAndCommonDemo.Exception.BusinessException;
import org.example.utilAndCommonDemo.unit.IDcreate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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

    @Resource
    private TReceiptHeadService receiptHeadService;

    @Resource
    private OGoodsSpecificationService goodsSpecificationService;


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
        if (!receiptLine.getStatus().equals(EnumReceiptTask.INSAwait.getCode())) {
            throw new BusinessException("该订单已经在检验中或者已经完成");
        }


        List<String> listitem = JSONObject.parseObject(String.valueOf(receiptLine.getItemList()),List.class);
        receiptLine.setStatus(EnumReceiptTask.INSOngoing.getCode());
        receiptLineService.updateById(receiptLine);

        // 修改head的订单
        TReceiptHead receiptHead = receiptHeadService.getById(receiptLine.getRheadId());
        receiptHead.setStatus(EnumReceiptTask.RECOngoing.getCode());
        receiptHeadService.updateById(receiptHead);

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
            receiptItemService.updateById(receiptItem);

            // 创建验收单行
            TCheckLine checkLine = new TCheckLine();
            checkLine.setChecklineid(IDcreate.getStringId(8));
            checkLine.setCheadid(checkHead.getCheadid());
            checkLine.setRitemId(x);
            checkLine.setSpuId(receiptItem.getSpuId());
            checkLine.setSpecId(receiptItem.getSpecId());
            checkLine.setItemList(JSONObject.toJSONString(EnumReceiptTask.INSisNULL.getCode()));
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void doInspect(String checkid, String name, String telephone, Double totalnum, Long specid) {
        TCheckLine checkLine = checkLineService.getById(checkid);
        if (checkLine == null) {
            throw new BusinessException("不存在这个检验任务");
        }

        if (!checkLine.getStatus().equals(EnumReceiptTask.INSAwait.getCode())) {
            throw new BusinessException("这个任务不需要检验,如果真的要检验请通知管理员进行复检");
        }
        // 更新入库单的状态
        TReceiptItem receiptItem = receiptItemService.getById(checkLine.getRitemId());
        receiptItem.setEndtime(new Date());
        receiptItem.setStatus(EnumReceiptTask.INSFinish.getCode());
        receiptItemService.updateById(receiptItem);

        // 检验
        checkLine.setOperateName(name);
        checkLine.setOperateTelephone(telephone);
        checkLine.setTotalNum(totalnum);
        OGoodsSpecification specification = null;
        if (specid != null) {
            specification = goodsSpecificationService.getById(specid);
            if (specification != null){
                checkLine.setSpecId(specid);
            } else {
                throw new BusinessException("规格不对");
            }
        } else {
            specification = goodsSpecificationService.getById(checkLine.getSpecId());
        }


        // 检验完成后
        if (specification.getNumUnit().equals(EnumGood.Number.getCode())) {
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < totalnum; i++) {
                Long id = IDcreate.getLongIdMIN6();
                list.add(id);
            }
            checkLine.setItemList(JSONObject.toJSONString(list));
        } else {

            String jsonString = JSONObject.toJSONString(EnumGood.Weight.getCode());
            checkLine.setItemList(jsonString);

        }

        checkLine.setStatus(EnumReceiptTask.INSFinish.getCode());
        checkLineService.updateById(checkLine);

    }


}
