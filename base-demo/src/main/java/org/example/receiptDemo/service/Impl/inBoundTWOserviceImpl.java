package org.example.receiptDemo.service.Impl;

import com.alibaba.fastjson2.JSONObject;
import org.example.o_mysql.domain.TInboundHead;
import org.example.o_mysql.service.TInboundHeadService;
import org.example.receiptDemo.service.InBoundService;
import org.example.receiptDemo.service.inBoundTWOservice;
import org.example.utilAndCommonDemo.Enum.EnumInbound;
import org.example.utilAndCommonDemo.Exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class inBoundTWOserviceImpl implements inBoundTWOservice {

    @Resource
    private InBoundService boundService;

    @Resource
    private TInboundHeadService inboundHeadService;

    @Override
    public void finishall(Long id) {

        TInboundHead inboundHead = inboundHeadService.getById(id);
        if (inboundHead == null) {
            throw new BusinessException("任务不存在");
        }

        if (inboundHead.getStatus().equals(EnumInbound.FINSH.getCode())) {
            throw new BusinessException("任务已经完成");
        }

        List<Long> getList = JSONObject.parseObject(inboundHead.getGetIdList().toString(),List.class);

        for (Long getId : getList) {
            try{
                boundService.finishGetTask(getId,id,"名称","15575025059");
            }catch (Exception e){
                if (! e.getMessage().equals("任务已经完成")) {
                    throw new BusinessException(e.getMessage());
                }
            }
        }

        List<Long> putList = JSONObject.parseObject(inboundHead.getPutIdList().toString(),List.class);
        for (Long putId : putList) {
            try{
                boundService.finishPutTask(putId,id,"名称","15575025059",new Date());
            }catch (Exception e){
                if (! e.getMessage().equals("任务已经完成")) {
                    throw new BusinessException(e.getMessage());
                }
            }
        }
    }


}
