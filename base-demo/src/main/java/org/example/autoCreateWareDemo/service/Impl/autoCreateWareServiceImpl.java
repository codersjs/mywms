package org.example.autoCreateWareDemo.service.Impl;

import org.example.autoCreateWareDemo.model.autoCreateWareRequest;
import org.example.autoCreateWareDemo.model.autoReservoir;
import org.example.autoCreateWareDemo.model.autoshelves;
import org.example.autoCreateWareDemo.service.autoCreateWareService;
import org.example.o_mysql.domain.*;
import org.example.o_mysql.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 自动生成仓库
 */
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

    @Resource
    private OShelvesTypeService shelvesTypeService;

    @Resource
    private OHeapTypeService heapTypeService;


    @Override
    public void create(autoCreateWareRequest request) {


        // 获取所有种类的货架编号
        HashMap<Long, OShelvesType> stypehash = new HashMap<>();

        // 获取所有种类的堆区编号
        HashMap<Long, OHeapType> htypehash = new HashMap<>();

        // 添加仓库
        OWarehouse warehouse = new OWarehouse();
        warehouse.setName(request.getWarename());
        warehouse.setLength(request.getLength());
        warehouse.setWidth(request.getWidth());
        warehouse.setLayout(request);
        warehouseService.save(warehouse);

        // 货位自动生成编号
        int n = 1;
        // 货架
        int m = 1;
        // 货区
        int k = 1;
        // 堆区
        int p = 1;

        // 获取所有的货区
        List<autoReservoir> reseList = request.getReservoirs();
        for (autoReservoir reservoir : reseList) {
            OReservoirArea reservoirArea = new OReservoirArea();
            reservoirArea.setName("R00"+k++);
            reservoirArea.setLength(reservoir.getLength());
            reservoirArea.setWidth(reservoir.getWidth());
            // 货架朝向
            reservoirArea.setShedir(reservoir.getDirection());
            // 仓库编号
            reservoirArea.setWareId(warehouse.getId());
            // 库区位置
            String resPostion = reservoir.getPostionX()+","+reservoir.getPostionY();
            reservoirArea.setPostion(resPostion);

            reservoirAreaService.save(reservoirArea);

            List<autoshelves> shelvesListh = reservoir.getAutoshelvesList();
            for (autoshelves shelves : shelvesListh) {

                if (shelves.getIstypenum().equals("货架")) {

                    OShelvesType shelvesType =stypehash.get(shelves.getTypeId());
                    if (shelvesType == null) {
                        shelvesType = shelvesTypeService.getById(shelves.getTypeId());
                        stypehash.put(shelves.getTypeId(), shelvesType);
                    }

                    // 生成货架
                    OShelves oShelves = new OShelves();
                    oShelves.setName("S00"+m++);
                    String osPostion = shelves.getPostionX()+","+shelves.getPostionY();
                    oShelves.setPostion(osPostion);
                    oShelves.setWareId(warehouse.getId());
                    oShelves.setResId(reservoirArea.getId());
                    oShelves.setTypeId(shelves.getTypeId());
                    shelvesService.save(oShelves);

                    // 生成货位
                    Long x = shelvesType.getLayerNum();
                    Long y = shelvesType.getLayer();

                    for (int i = 0; i < x; i++) {

                        for (int j = 0; j < y; j++) {

                            if (reservoir.getDirection().equals("横向")) {
                                Long Xx = x+i; // x坐标
                                Long Zz = y; // z坐标
                                OFreight freight = new OFreight();
                                freight.setName("F00"+n++);
                                freight.setWareId(warehouse.getId());
                                freight.setResId(reservoirArea.getId());
                                freight.setSheId(oShelves.getId());
                                freight.setSpuno(0L);
                                freight.setStocksMaxNum(0L);
                                freight.setDec("初始化");
                                freight.setX(Xx);
                                freight.setY(shelves.getPostionY());
                                freight.setZ(Zz);
                                freightService.save(freight);
                            }

                            if (reservoir.getDirection().equals("纵向")) {
                                Long Yy = x+i;
                                Long Zz = y;
                                OFreight freight = new OFreight();
                                freight.setName("F00"+n++);
                                freight.setWareId(warehouse.getId());
                                freight.setResId(reservoirArea.getId());
                                freight.setSheId(oShelves.getId());
                                freight.setSpuno(0L);
                                freight.setStocksMaxNum(0L);
                                freight.setDec("初始化");
                                freight.setX(shelves.getPostionX());
                                freight.setY(Yy);
                                freight.setZ(Zz);
                                freightService.save(freight);
                            }


                        }

                    }


                }

                if (shelves.getIstypenum().equals("堆区")) {

                    OHeapType oHeapType = htypehash.get(shelves.getTypeId());
                    if (oHeapType == null) {
                        oHeapType = heapTypeService.getById(shelves.getTypeId());
                        htypehash.put(shelves.getTypeId(), oHeapType);
                    }

                    // 生成堆区
                    OHeap oHeap = new OHeap();
                    oHeap.setName("H00"+p++);
                    oHeap.setTypeId(shelves.getTypeId());
                    String ohPostion = shelves.getPostionX()+","+shelves.getPostionY();
                    oHeap.setPostion(ohPostion);
                    oHeap.setWareId(warehouse.getId());
                    oHeap.setResId(reservoirArea.getId());
                    heapService.save(oHeap);

                }

            }

        }

    }


}
