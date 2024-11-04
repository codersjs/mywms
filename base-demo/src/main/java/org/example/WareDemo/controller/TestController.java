package org.example.WareDemo.controller;

import org.example.WareDemo.model.TestBody;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class TestController {

    @PostMapping("/hello")
    public ResultData hello(@RequestParam String code ,@RequestBody TestBody testBody) {
        System.out.println(testBody);
        return new ResultData(code,null ,testBody.getId()+"666");
    }
}
