package org.example.WareDemo.controller;

import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

    @GetMapping("/hello")
    public ResultData hello() {
        return ResultData.sucess("200", "Hello World");
    }
}
