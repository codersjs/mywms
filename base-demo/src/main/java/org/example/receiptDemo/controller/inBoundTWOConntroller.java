package org.example.receiptDemo.controller;

import org.example.receiptDemo.service.inBoundTWOservice;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class inBoundTWOConntroller {

    @Resource
    private inBoundTWOservice boundTWOservice;

    @GetMapping("/bound/finish/all")
    public ResultData finishall(@RequestParam("id") Long id) {
        boundTWOservice.finishall(id);
        return ResultData.sucess("200",null);
    }

}
