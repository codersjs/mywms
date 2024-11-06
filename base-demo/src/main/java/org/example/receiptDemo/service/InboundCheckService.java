package org.example.receiptDemo.service;

import org.example.receiptDemo.model.InboudModel.InboundRequesut;
import org.example.utilAndCommonDemo.Exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class InboundCheckService {


    public void check(InboundRequesut requesut) {

        if (requesut == null) {
            throw new BusinessException("请求不存在");
        }

        if (requesut.getManagertelephone() == null || requesut.getManagertelephone().trim().equals("")) {
            throw new BusinessException("电话不能为空");
        }

        if (requesut.getManagername() == null || requesut.getManagername().trim().equals("")) {
            throw new BusinessException("名称不能为空");
        }
        System.out.println(requesut);
    }
}
