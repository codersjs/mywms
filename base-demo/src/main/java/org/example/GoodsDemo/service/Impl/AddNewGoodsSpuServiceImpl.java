package org.example.GoodsDemo.service.Impl;

import com.alibaba.fastjson2.JSONObject;
import org.example.GoodsDemo.demo.goodsSpecification;
import org.example.GoodsDemo.service.AddNewGoodsSpuService;
import org.example.o_mysql.domain.OGoodsSpecification;
import org.example.o_mysql.domain.OGoodsType;
import org.example.o_mysql.service.OGoodsSpecificationService;
import org.example.o_mysql.service.OGoodsTypeService;
import org.example.utilAndCommonDemo.Exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddNewGoodsSpuServiceImpl implements AddNewGoodsSpuService {

    @Resource
    private OGoodsSpecificationService goodsSpecificationService;

    @Resource
    private OGoodsTypeService goodsTypeService;

    @Override
    public void addSpu(String spuName, Integer shelife, List<goodsSpecification> specList) {
        // json
        JSONObject jsonObject = new JSONObject();

        // 1. 添加spu
        OGoodsType goodsType = new OGoodsType();
        goodsType.setSpunoName(spuName);
        goodsType.setDefaultShelfLife(shelife);

        // 2.添加specList
        if (specList.size()<=0 || specList.get(0) == null) {
            throw new BusinessException("规格不能为空");
        }
        goodsType.setSpecificationTypeList(jsonObject.toJSONString(specList));
        goodsTypeService.save(goodsType);

        // 3. 添加规格
        for (goodsSpecification specification : specList) {
            OGoodsSpecification goodsSpecification = new OGoodsSpecification();
            goodsSpecification.setSpuName(spuName);
            goodsSpecification.setSpecName(specification.getSpecName());
            // 1 是 货架，2 是 堆区
            if (specification.getStockType().equals("货架")||specification.getStockType().equals("堆区")) {
                goodsSpecification.setStockType(specification.getStockType());
            } else {
                throw new BusinessException("存储类型不属于货架或堆区");
            }
            goodsSpecification.setStockMaxNum(specification.getStockMaxNum());
            goodsSpecification.setSpuno(goodsType.getSpuno());
            goodsSpecificationService.save(goodsSpecification);
        }


    }

}
