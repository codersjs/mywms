package org.example.GoodsDemo.controller;

import org.example.GoodsDemo.model.SPURequest;
import org.example.GoodsDemo.service.SpuService;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class SpuController {

    @Resource
    private SpuService spuService;

    /**
     * 增加新的spu,新的一类商品
     * @param request
     * @return
     */
    @PostMapping("/spu/addnew")
    public ResultData addNewSpu(@RequestBody SPURequest request) {
        spuService.addSpu(request.getSpuname(),request.getDefaultShelfLife(),request.getSpecList());
        return ResultData.sucess("200",null);
    }


    /**
     * 设置默认保质期
     * @param spuid
     * @param day
     * @return
     */
    @PostMapping("/set/def/shelf")
    public ResultData setDefaultShelfLife(@RequestParam("spuid") Long spuid,@RequestParam("day") Integer day) {
        spuService.setDefaultShelfLife(spuid,day);
        return ResultData.sucess("200",null);
    }

    /**
     * 设置保质期预警
     * @param spuid
     * @param day
     * @return
     */
    @PostMapping("/set/warn/shelf")
    public ResultData setWarnShelf(@RequestParam("spuid") Long spuid,@RequestParam("warnday") Integer day) {
        spuService.setWarnShelf(spuid,day);
        return ResultData.sucess("200",null);
    }

    /**
     * 设置最小数量预警
     * @param spuid
     * @param minnum
     * @return
     */
    @PostMapping("/set/warn/minnum")
    public ResultData setWarnnum(@RequestParam("spuid") Long spuid,@RequestParam("minnum") Double minnum) {
        spuService.setWarnnum(spuid,minnum);
        return ResultData.sucess("200",null);
    }

    /**
     * 删除spu
     * @param spuid
     * @return
     */
    @GetMapping("/del/spu")
    public ResultData deletespu(@RequestParam("spuid") Long spuid) {
        spuService.deletespu(spuid);
        return ResultData.sucess("200",null);
    }



}
