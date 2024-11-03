package org.example.GoodsDemo.service;

import org.example.GoodsDemo.demo.goodsSpecification;

import java.util.List;

public interface AddNewGoodsSpuService {
    void addSpu(String spuName, Integer shelife, List<goodsSpecification> specList);
}
