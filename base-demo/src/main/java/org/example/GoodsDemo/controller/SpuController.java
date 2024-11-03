package org.example.GoodsDemo.controller;

import org.example.GoodsDemo.demo.SPURequest;
import org.example.GoodsDemo.service.AddNewGoodsSpuService;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SpuController {

    @Resource
    private AddNewGoodsSpuService addNewGoodsSpuService;

    @PostMapping("/spu/addnew")
    public ResultData SpuController(@RequestBody SPURequest request) {
        addNewGoodsSpuService.addSpu(request.getSpuname(),request.getDefaultShelfLife(),request.getSpecList());
        return ResultData.sucess("200",null);
    }

}
