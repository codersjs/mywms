package org.example.receiptDemo.service.Impl;

import com.alibaba.fastjson2.JSONObject;
import org.example.o_mysql.domain.TReceiptHead;
import org.example.o_mysql.service.TReceiptHeadService;
import org.example.o_mysql.service.TReceiptItemService;
import org.example.o_mysql.service.TReceiptLineService;
import org.example.receiptDemo.demo.ReceiptRequest;
import org.example.receiptDemo.service.ReceiptService;

import javax.annotation.Resource;

public class ReceiptServiceImpl implements ReceiptService {

    @Resource
    private TReceiptHeadService receiptHeadService;

    @Resource
    private TReceiptLineService receiptLineService;

    @Resource
    private TReceiptItemService receiptItemService;

    @Override
    public void createReceipt(ReceiptRequest request) {
        // json
        JSONObject jsonObject = new JSONObject();
        System.out.println(request);
    }
}
