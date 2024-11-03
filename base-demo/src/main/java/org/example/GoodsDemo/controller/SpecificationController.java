package org.example.GoodsDemo.controller;


import org.example.GoodsDemo.service.SpecificationService;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SpecificationController {


    @Resource
    private SpecificationService specificationService;

    /**
     * 增加新的规格
     * @param spuid
     * @param spuname
     * @param specname
     * @param stocktype
     * @param stockmaxnum
     * @return
     */
    @PostMapping("/spec/add")
    public ResultData specadd(@RequestParam("spuid") Long spuid,
                              @RequestParam("spuname") String spuname,
                              @RequestParam("specname") String specname,
                              @RequestParam("stocktype") String stocktype,
                              @RequestParam("stockmaxnum") Double stockmaxnum) {
        specificationService.specadd(spuid,spuname,specname,stocktype,stockmaxnum);
        return ResultData.sucess("200",null);
    }

    /**
     * 删除规格
     * @param spuid
     * @param specid
     * @return
     */
    @PostMapping("/spec/del")
    public ResultData specdelete(@RequestParam("spuid") Long spuid,
                                 @RequestParam("specid") Long specid,
                                 @RequestParam("specname") String specname) {
        specificationService.specdelete(spuid,specid,specname);
        return ResultData.sucess("200",null);
    }

    /**
     * 设置规格的最大数量
     * @param specid
     * @param stockmaxnum
     * @return
     */
    @PostMapping("/spec/set/maxnum")
    public ResultData specsetmaxnum(@RequestParam("specid") Long specid,
                                    @RequestParam("stockmaxnum") Double stockmaxnum) {
        specificationService.specsetmaxnum(specid,stockmaxnum);
        return ResultData.sucess("200",null);
    }

    /**
     * 设置可用数量的预警
     * @param specid
     * @param stockwarnnum
     * @return
     */
    @PostMapping("/spec/set/warnnum")
    public ResultData specsetwarnnum(@RequestParam("specid") Long specid,
                              @RequestParam("stockwarnnum") Double stockwarnnum) {
        specificationService.specsetwarnnum(specid,stockwarnnum);
        return ResultData.sucess("200",null);
    }



}
