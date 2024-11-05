package org.example.GoodsDemo.service;

import org.example.GoodsDemo.demo.GoodsSpecRequest;


import java.util.List;

public interface SpuService {
    void addSpu(String spuName, Integer shelife, List<GoodsSpecRequest> specList);

    void setDefaultShelfLife(Long spuid, Integer day);

    void setWarnShelf(Long spuid, Integer day);

    void setWarnnum(Long spuid, Double minnum);

    void deletespu(Long spuid);
}
