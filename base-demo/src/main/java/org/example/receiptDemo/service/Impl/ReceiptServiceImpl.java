package org.example.receiptDemo.service.Impl;

import com.alibaba.fastjson2.JSONObject;
import org.example.o_mysql.domain.TReceiptHead;
import org.example.o_mysql.domain.TReceiptItem;
import org.example.o_mysql.domain.TReceiptLine;
import org.example.o_mysql.service.TReceiptHeadService;
import org.example.o_mysql.service.TReceiptItemService;
import org.example.o_mysql.service.TReceiptLineService;
import org.example.receiptDemo.model.ReceiptModel.BatchRequest;
import org.example.utilAndCommonDemo.Enum.EnumReceiptTask;
import org.example.receiptDemo.model.ReceiptModel.ItemRequest;
import org.example.receiptDemo.model.ReceiptModel.ReceiptRequest;
import org.example.receiptDemo.service.ReceiptService;
import org.example.utilAndCommonDemo.Exception.BusinessException;
import org.example.utilAndCommonDemo.unit.IDcreate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Resource
    private TReceiptHeadService receiptHeadService;

    @Resource
    private TReceiptLineService receiptLineService;

    @Resource
    private TReceiptItemService receiptItemService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createReceipt(ReceiptRequest request) {

         if(request.getSource() == null) {
             throw new BusinessException("来源不能为空");
         }
        if(request.getName() == null) {
            throw new BusinessException("负责人名称");
        }
        if(request.getTelephone() == null) {
            throw new BusinessException("负责人电话不能为空");
        }


        TReceiptHead receiptHead = new TReceiptHead();
        receiptHead.setSource(request.getSource());
        receiptHead.setManagerName(request.getName());
        receiptHead.setManagerTelephone(request.getTelephone());
        receiptHead.setStatus(EnumReceiptTask.RECNewOrder.getCode());
        receiptHead.setRheadId(IDcreate.getStringId(8));
        List<String> batchIdList = new ArrayList<>();
        for (BatchRequest y: request.getList()) {
            String bId = IDcreate.getRandomBatchId();
            batchIdList.add(bId);
            TReceiptLine batch = new TReceiptLine();
            batch.setBatchId(bId);
            batch.setRheadId(receiptHead.getRheadId());
            batch.setStatus(EnumReceiptTask.INSAwait.getCode());
            List<String> itemList = new ArrayList<>();
            for (ItemRequest x : y.getList()) {
                if(x.getSpecId() == null) {
                    throw new BusinessException("规格不能为空");
                }
                if(x.getSpuId() == null) {
                    throw new BusinessException("物品类型不能为空");
                }
                if(x.getGetNum() == null) {
                    throw new BusinessException("入库数量不能为空");
                }
                if(x.getTotalWeight() == null) {
                    throw new BusinessException("入库的重量不能为空");
                }
                TReceiptItem item = new TReceiptItem();
                item.setRitemId(IDcreate.getRandomBatchId("IM"));
                item.setBatchId(batch.getBatchId());
                item.setSpecId(x.getSpecId());
                item.setSpuId(x.getSpuId());
                item.setGetNum(x.getGetNum());
                // 对方提供的重量
                item.setTotalWeight(x.getTotalWeight());
                item.setStatus(EnumReceiptTask.INSAwait.getCode());
                itemList.add(item.getRitemId());
                receiptItemService.save(item);
            }
            batch.setTaskNum(itemList.size());
            batch.setItemList(JSONObject.toJSONString(itemList));
            receiptLineService.save(batch);
        }
        receiptHead.setBatchList(JSONObject.toJSONString(batchIdList));
        receiptHead.setTaskNum(batchIdList.size());
        receiptHeadService.save(receiptHead);
    }



}
