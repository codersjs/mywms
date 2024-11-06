package org.example.GoodsDemo.service.Impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.example.GoodsDemo.model.GoodsSpecRequest;
import org.example.GoodsDemo.service.SpecificationService;
import org.example.GoodsDemo.service.SpuService;
import org.example.o_mysql.domain.OGoodsSpecification;
import org.example.o_mysql.domain.OGoodsType;
import org.example.o_mysql.service.OGoodsSpecificationService;
import org.example.o_mysql.service.OGoodsTypeService;
import org.example.utilAndCommonDemo.Enum.EnumGood;
import org.example.utilAndCommonDemo.Exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Resource
    private OGoodsSpecificationService goodsSpecificationService;

    @Resource
    private OGoodsTypeService goodsTypeService;

    @Resource
    private SpecificationService specificationService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addSpu(String spuName, Integer shelife, List<GoodsSpecRequest> specList) {
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
        for (GoodsSpecRequest specification : specList) {
            OGoodsSpecification goodsSpecification = new OGoodsSpecification();
            goodsSpecification.setSpuName(spuName);
            goodsSpecification.setSpecName(specification.getSpecName());

            // 如果单位类信息不对就报错
            if (EnumGood.getReturnCodeEnum(specification.getNumunit()) == null) {
                throw new BusinessException("单位不对或者没有检验");
            }

            goodsSpecification.setNumUnit(specification.getNumunit());
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

    @Override
    public void setDefaultShelfLife(Long spuid, Integer day) {
        if (day<=0) {
            throw new BusinessException("保质期时间问题");
        }
        OGoodsType goodsType =  goodsTypeService.getById(spuid);
        if (goodsType==null) {
            throw new BusinessException("商品大类不存在");
        }
        goodsType.setDefaultShelfLife(day);
        goodsTypeService.save(goodsType);
    }

    @Override
    public void setWarnShelf(Long spuid, Integer day) {
        OGoodsType goodsType =  goodsTypeService.getById(spuid);
        if (goodsType==null) {
            throw new BusinessException("商品大类不存在");
        }
        goodsType.setWarnShelfLife(day);
        goodsTypeService.save(goodsType);
    }

    @Override
    public void setWarnnum(Long spuid, Double minnum) {
        OGoodsType goodsType =  goodsTypeService.getById(spuid);
        if (goodsType==null) {
            throw new BusinessException("商品大类不存在");
        }
        goodsType.setWarnTotalNum(minnum);
        goodsTypeService.save(goodsType);
    }

    @Override
    public void deletespu(Long spuid) {
        OGoodsType goodsType =  goodsTypeService.getById(spuid);
        if (goodsType==null) {
            throw new BusinessException("商品大类不存在");
        }

        LambdaUpdateWrapper lambdaUpdateWrapper = new LambdaUpdateWrapper<OGoodsSpecification>()
                .ge(OGoodsSpecification::getSpuno,spuid);

        List<OGoodsSpecification> list = goodsSpecificationService.list(lambdaUpdateWrapper);

        for (OGoodsSpecification specification : list) {
            if (specification.getTotalQuantity()>0) {
                throw new BusinessException("仓库中存在该类商品");
            }
        }
        // 进行删除
        for (OGoodsSpecification specification : list) {
            specificationService.specdelete(spuid,specification.getSpecid(), specification.getSpecName());
        }
        goodsTypeService.removeById(spuid);

    }
}
