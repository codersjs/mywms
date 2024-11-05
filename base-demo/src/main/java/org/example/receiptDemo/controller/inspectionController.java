package org.example.receiptDemo.controller;

import org.example.receiptDemo.service.InspectService;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class inspectionController {

    @Resource
    private InspectService inspectService;


    // 进行验收
    @PostMapping("/insp/create")
    public ResultData createInspect(@RequestParam("batch") String batch,
                                    @RequestParam(value = "name",required = false) String name,
                                    @RequestParam(value = "telephone",required = false) String telephone) {
        inspectService.createInspect(batch,name,telephone);
        return ResultData.sucess("200",null);
    }


}
