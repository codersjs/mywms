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


    /**
     * 根据批次创建验收
     * @param batch
     * @param name
     * @param telephone
     * @return
     */
    @PostMapping("/insp/create")
    public ResultData createInspect(@RequestParam("batch") String batch,
                                    @RequestParam(value = "name",required = false) String name,
                                    @RequestParam(value = "telephone",required = false) String telephone) {
        inspectService.createInspect(batch,name,telephone);
        return ResultData.sucess("200",null);
    }


    @PostMapping("/insp/check")
    public ResultData doInspect(@RequestParam("checkid") String checkid,
                                @RequestParam(value = "name") String name,
                                @RequestParam(value = "telephone") String telephone,
                                @RequestParam(value = "totalnum") Double totalnum ,
                                @RequestParam(value = "specid", required = false) Long specid) {
        inspectService.doInspect(checkid,name,telephone,totalnum,specid);
        return ResultData.sucess("200",null);
    }



}
