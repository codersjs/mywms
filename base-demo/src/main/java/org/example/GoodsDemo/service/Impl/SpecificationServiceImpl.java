package org.example.GoodsDemo.service.Impl;

import com.alibaba.fastjson2.JSONObject;
import org.example.GoodsDemo.demo.GoodsSpecRequest;
import org.example.GoodsDemo.service.SpecificationService;
import org.example.o_mysql.domain.OGoodsSpecification;
import org.example.o_mysql.domain.OGoodsType;
import org.example.o_mysql.service.OGoodsSpecificationService;
import org.example.o_mysql.service.OGoodsTypeService;
import org.example.utilAndCommonDemo.Exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Resource
    private OGoodsSpecificationService goodsSpecificationService;

    @Resource
    private OGoodsTypeService goodsTypeService;

    @Override
    public void specadd(Long spuid, String spuname, String specname, String stocktype, Double stockmaxnum, String numunit) {


        OGoodsSpecification goodsSpec = new OGoodsSpecification();
        goodsSpec.setSpuName(spuname);
        goodsSpec.setSpuno(spuid);
        goodsSpec.setSpecName(specname);
        goodsSpec.setStockType(stocktype);
        goodsSpec.setStockMaxNum(stockmaxnum);
        goodsSpec.setNumUnit(numunit);
        // 在spu中增加
        OGoodsType oGoodsType = goodsTypeService.getById(spuid);
        // 获取json字符串
        List<GoodsSpecRequest> list = JSONObject.parseObject((String) oGoodsType.getSpecificationTypeList(),List.class);

        GoodsSpecRequest specification = new GoodsSpecRequest();
        specification.setSpecName(specname);
        specification.setStockType(stocktype);
        specification.setStockMaxNum(stockmaxnum);
        list.add(specification);
        oGoodsType.setSpecificationTypeList(JSONObject.toJSONString(list));
        goodsTypeService.updateById(oGoodsType);
        goodsSpecificationService.save(goodsSpec);
    }

    @Override
    public void specsetmaxnum(Long specid, Double stockmaxnum) {
        OGoodsSpecification goodsSpecification = new OGoodsSpecification();
        goodsSpecification.setSpecid(specid);
        goodsSpecification.setStockMaxNum(stockmaxnum);
        goodsSpecificationService.updateById(goodsSpecification);
    }

    @Override
    public void specsetwarnnum(Long specid, Double stockwarnnum) {
        OGoodsSpecification goodsSpecification = new OGoodsSpecification();
        goodsSpecification.setSpecid(specid);
        goodsSpecification.setWarnTotalNum(stockwarnnum);
        goodsSpecificationService.updateById(goodsSpecification);
    }

    @Override
    public void specdelete(Long spuid, Long specid, String specname) {

        OGoodsSpecification specification = goodsSpecificationService.getById(specid);

        if (specification==null) {
            throw new BusinessException("该规格不存在或者已经被删除");
        }
        if (specification.getTotalQuantity() > 0) {
            throw new BusinessException("货架上存在该规格下的物品");
        }

        // 进行删除

        // 在spu中删除
        OGoodsType oGoodsType = goodsTypeService.getById(spuid);
        // 获取json字符串
        List list = JSONObject.parseObject((String) oGoodsType.getSpecificationTypeList(),List.class);


        int x = -1;
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject = JSONObject.from(list.get(i));
            String ch = jsonObject.toJSONString(jsonObject);
            GoodsSpecRequest specification2 = JSONObject.parseObject(ch, GoodsSpecRequest.class);
            if (specification2.getSpecName().equals(specname)) {
                x = i;
            }
        }
        if (x>=0)
            list.remove(x);
        oGoodsType.setSpecificationTypeList(JSONObject.toJSONString(list));
        goodsTypeService.updateById(oGoodsType);
        goodsSpecificationService.removeById(specid);

    }



}
