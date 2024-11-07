package org.example.receiptDemo.controller;

import org.example.receiptDemo.model.InboudModel.InboundRequesut;
import org.example.receiptDemo.service.InBoundService;
import org.example.receiptDemo.service.InboundCheckService;
import org.example.utilAndCommonDemo.Exception.BusinessException;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

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

    // 完成单个拿货任务
    @PostMapping("/create/finish/get")
    public ResultData finishGetTask(@RequestParam("id") Long id,
                                    @RequestParam("headid") Long headid,
                                    @RequestParam("name") String name,
                                    @RequestParam("telephone") String telephone) {
        inBoundService.finishGetTask(id,headid,name,telephone);
        return ResultData.sucess("200",null);
    }


    // 完成单个上架货任务
    @PostMapping("/create/finish/put")
    public ResultData finishPutTask(@RequestParam("id") Long id,
                                    @RequestParam("headid") Long headid,
                                    @RequestParam("name") String name,
                                    @RequestParam("telephone") String telephone,
                                    @RequestParam(value = "date",required = false) String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time;
        if (date!=null) {
            try {
                time = sdf.parse(date);
            } catch (ParseException e) {
                throw new BusinessException("日期的格式不对");
            }
        } else {
            time = new Date();
        }

        inBoundService.finishPutTask(id, headid, name, telephone, time);
        return ResultData.sucess("200", null);
    }


}
