package org.example.receiptDemo.controller;

import org.example.receiptDemo.demo.ReceiptRequest;
import org.example.receiptDemo.service.ReceiptService;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class receiptController {

    @Resource
    private ReceiptService receiptService;

    /**
     * 创建收货任务,将批次确定下来
     * @param request
     * @return
     */
    @PostMapping("/rec/create")
    public ResultData createReceipt(@RequestBody ReceiptRequest request) {
        receiptService.createReceipt(request);
        return new ResultData<>("200",null,"sucess");
    }

    // 检验


    // 创建上架任务

}
