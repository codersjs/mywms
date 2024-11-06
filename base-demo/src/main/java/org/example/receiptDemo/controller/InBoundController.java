package org.example.receiptDemo.controller;

import org.example.receiptDemo.model.InboudModel.InboundRequesut;
import org.example.receiptDemo.service.InBoundService;
import org.example.receiptDemo.service.InboundCheckService;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class InBoundController {

    @Resource
    private InBoundService inBoundService;

    @Resource
    private InboundCheckService inboundCheck;
    // 生成入库单
    @PostMapping("/create/inbound")
    public ResultData createInboundTask(@RequestBody InboundRequesut requesut) {

        // InboundCheck 进行校验
        inboundCheck.check(requesut);

        inBoundService.createInboundTask(requesut.getCheckHeadList(),requesut.getGetList(),requesut.getPutList(),requesut.getManagername(),requesut.getManagertelephone());

        return ResultData.sucess("200",null);
    }

    // 入库单头，入库单行（批次）


    // 入库，状态改变

}
