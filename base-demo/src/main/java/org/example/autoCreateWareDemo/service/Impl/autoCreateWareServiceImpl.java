package org.example.autoCreateWareDemo.service.Impl;

import org.example.autoCreateWareDemo.model.autoCreateWareRequest;
import org.example.autoCreateWareDemo.model.autoReservoir;
import org.example.autoCreateWareDemo.service.autoCreateWareService;
import org.example.o_mysql.domain.OWarehouse;
import org.example.o_mysql.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class autoCreateWareServiceImpl implements autoCreateWareService {
    // 创建货位
    @Resource
    private OFreightService freightService;

    // 创建货架
    @Resource
    private OShelvesService shelvesService;

    // 创建堆区
    @Resource
    private OHeapService heapService;

    // 创建库区
    @Resource
    private OReservoirAreaService reservoirAreaService;

    // 创建仓库
    @Resource
    private OWarehouseService warehouseService;


    @Override
    public void create(autoCreateWareRequest request) {

        // 添加仓库
        OWarehouse warehouse = new OWarehouse();
        warehouse.setName(request.getWarename());
        warehouse.setLength(request.getLength());
        warehouse.setWidth(request.getWidth());
        warehouse.setLayout(request);
        warehouseService.save(warehouse);



        // 获取所有的货区
        List<autoReservoir> reseList = request.getReservoirs();



        // 获取所有种类的货架编号

        // 获取所有种类的堆区编号
    }


}
