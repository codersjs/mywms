package org.example.WareDemo.controller;


import org.example.o_mysql.domain.OHeapType;
import org.example.o_mysql.domain.OShelvesType;
import org.example.o_mysql.service.OHeapTypeService;
import org.example.o_mysql.service.OShelvesTypeService;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.example.utilAndCommonDemo.Response.ReturnCodeEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 添加货架类型和堆放区域类型
 */
@RestController
public class addStorageUnitController {

    @Resource
    private OShelvesTypeService shelvesTypeService;

    @Resource
    private OHeapTypeService heapTypeService;
    /**
     * 增加新的货架
     * @param name
     * @param layer
     * @param layerNum
     * @return
     */
    @PostMapping("/add/storage/shelves")
    public ResultData addShelves(@RequestParam("name") String name,
                                 @RequestParam("layer") Long layer,
                                 @RequestParam("layernum") Long layerNum,
                                 @RequestParam(value = "dec",required = false) String dec) {
        OShelvesType shelvesType = new OShelvesType();
        shelvesType.setDescription(dec);
        shelvesType.setLayer(layer);
        shelvesType.setLayerNum(layerNum);
        shelvesType.setName(name);
        shelvesTypeService.save(shelvesType);
        return ResultData.sucess(ReturnCodeEnum.RC200.getCode(), null);
    }

    /**
     * 增加新的堆货区
     * @param name
     * @param length
     * @param width
     * @param dec
     * @return
     */
    @PostMapping("/add/storage/heap")
    public ResultData addheap(@RequestParam("name") String name,
                              @RequestParam("length") Long length,
                              @RequestParam("width") Long width,
                              @RequestParam(value = "dec",required = false) String dec){
        OHeapType heapType = new OHeapType();
        heapType.setDescription(dec);
        heapType.setLength(length);
        heapType.setWidth(width);
        heapTypeService.save(heapType);

        return ResultData.sucess(ReturnCodeEnum.RC200.getCode(),null);
    }


}
