package org.example.WareDemo.controller;

import org.example.WareDemo.model.autoCreateWareRequest;
import org.example.WareDemo.service.autoCreateWareService;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.example.utilAndCommonDemo.Response.ReturnCodeEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 根据传入的仓库信息创建货架
 */
@RestController
public class autoCreateWareController {

    @Resource
    private autoCreateWareService createWareService;

    @PostMapping("/create/ware/doware")
    public ResultData autoCreateWare(@RequestBody autoCreateWareRequest request) {

        createWareService.create(request);

        return ResultData.sucess(ReturnCodeEnum.RC200.getCode(), null);
    }



}
