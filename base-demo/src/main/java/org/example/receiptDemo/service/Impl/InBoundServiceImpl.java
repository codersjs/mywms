package org.example.receiptDemo.service.Impl;


import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.o_mysql.domain.*;
import org.example.o_mysql.service.*;
import org.example.receiptDemo.model.InboudModel.InboundGet;
import org.example.receiptDemo.model.InboudModel.InboundTaskPeople;
import org.example.receiptDemo.service.InBoundService;
import org.example.utilAndCommonDemo.Enum.EnumInbound;
import org.example.utilAndCommonDemo.Enum.EnumReceiptTask;
import org.example.utilAndCommonDemo.Exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@Service
public class InBoundServiceImpl implements InBoundService {

    @Resource
    private TCheckHeadService checkHeadService;

    @Resource
    private TCheckLineService checkLineService;

    @Resource
    private OFreightService oFreightService;

    @Resource
    private OGoodsSpecificationService goodsSpecificationService;

    @Resource
    private TInboundPutService inboundPutService;

    @Resource
    private TInboundGetService inboundGetService;

    @Resource
    private TInboundHeadService inboundHeadService;


    /**
     * 创建放货任务，和取货任务
     * 放货任务：根据已经有同类的物品处进行添加，对于空的地方进行整体添加
     * @param checkHeadList
     * @param getList
     * @param putList
     * @param managername
     * @param managertelephone
     */
    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public void createInboundTask(List<String> checkHeadList, List<InboundTaskPeople> getList, List<InboundTaskPeople> putList, String managername, String managertelephone) {

        // 容器数量
        int Fnum = 20;

        // 获取为空的容器(100个)
        LambdaQueryWrapper  wrapper = new LambdaQueryWrapper<OFreight>()
                .ge(OFreight::getStocksNum,0)
                .ge(OFreight::getIncreaseNum,0);
        // 分页
        Page<OFreight> page = new Page(0,Fnum);

        // 获取分页
        List<OFreight> freightList = oFreightService.page(page,wrapper).getRecords();

        // 放货任务的ID
        List<Long> putlistID = new ArrayList<>();

        // 取货任务的ID
        List<Long> getlistID = new ArrayList<>();

        // 1. 获取批次下的任务是否都检验完成
        for (String x : checkHeadList) {
            TCheckHead checkHead = checkHeadService.getById(x);
            if (checkHead == null) {
                throw new BusinessException("编号为"+x+"改验收批次不存在");
            }
            if (!checkHead.getStatus().equals(EnumReceiptTask.RECFinish.getCode())) {
                if (checkHead.getStatus().equals(EnumReceiptTask.INSSHELVES.getCode())) {
                    throw new BusinessException("编号为"+x+"改验收批已经上架完成");
                }
                throw new BusinessException("编号为"+x+"改验收批没有完全建检验");
            }
        }

        // 2. 创建取货任务
        for (String x : checkHeadList) {
            int h = 0;
            TCheckHead checkHead = checkHeadService.getById(x);
            List<String> checkLineList = JSONObject.parseObject(checkHead.getCheckLineList().toString(),List.class);

            // 创建取货任务
            List<InboundGet> s = new ArrayList<>();

            for (String y : checkLineList) {

                TCheckLine checkLine = checkLineService.getById(y);

                if (checkLine.getStatus().equals(EnumReceiptTask.INSSHELVES.getCode())) {
                    continue;
                }
                Double total = checkLine.getTotalNum();
                // 获取物品的数量
                // 1. 判断使用有已经存过该物品的容器
                for (OFreight f : this.getSPUAndSPEC(checkLine.getSpuId(), checkLine.getSpecId())) {
                    if (total == 0D) break;
                    Double oknum = f.getStocksMaxNum() - f.getStocksNum() - f.getIncreaseNum();
                    if (oknum<=0) continue;
                    if (total >= oknum) {
                        total -= oknum;
                        // 生成put任务
                        f.setIncreaseNum(f.getIncreaseNum() + oknum);
                        putlistID.add(this.createputTask(f,oknum));
                    } else {
                        f.setIncreaseNum(f.getIncreaseNum() + total);
                        putlistID.add(this.createputTask(f,total));
                        total = 0D;
                    }
                }

                // 建立删除队列
                List<OFreight> del = new ArrayList<>();

                // 2. 放入新的容器中
                for (int i = 0; i < freightList.size(); i++) {
                    if (total == 0D) break;
                    OFreight f = freightList.get(i);
                    // 如果说之前的空货位已经存放过物品了，那么判断是不是同一个
                    if (f.getStocksMaxNum() >= 0.0001) {
                        if (checkLine.getSpecId().equals(f.getSpecid())) {
                            Double oknum = f.getStocksMaxNum() - f.getIncreaseNum();
                            if (oknum<=0) continue;
                            if (total>=oknum) {
                                total -= oknum;
                                f.setIncreaseNum(f.getIncreaseNum() + oknum);
                                putlistID.add(this.createputTask(f, f.getStocksMaxNum()));
                                del.add(f);
                            } else {
                                f.setIncreaseNum(f.getIncreaseNum() + total);
                                total = 0D;
                            }
                        }
                    } else {
                        // 获取最大容量
                        OGoodsSpecification specification = goodsSpecificationService.getById(checkLine.getSpecId());
                        Double maxnum = specification.getStockMaxNum();

                        if (total >= maxnum) {
                            total -= maxnum;

                            // 更新货位
                            f.setSpuno(specification.getSpuno());
                            f.setSpecid(checkLine.getSpecId());
                            f.setIncreaseNum(maxnum);
                            f.setStocksMaxNum(maxnum);
                            // 下达任务
                            putlistID.add(this.createputTask(f, maxnum));
                            del.add(f);
                        } else {
                            f.setSpuno(specification.getSpuno());
                            f.setSpecid(checkLine.getSpecId());
                            f.setIncreaseNum(total);
                            f.setStocksMaxNum(maxnum);
                            total = 0D;
                        }
                    }

                    // 生成取货单

                }
                // 删除装满的货位
                freightList.removeAll(del);

                // 只有仓库库存满了的时候，才会出现,取一半的情况
                if (total >= 0.001) {
                    checkLine.setTotalNum(total);
                    InboundGet inboundGet = new InboundGet();
                    inboundGet.setNum(checkLine.getTotalNum()-total);
                    inboundGet.setSpecid(checkLine.getSpecId());
                    s.add(inboundGet);
                    checkLineService.updateById(checkLine);
                } else {
                    h++;
                    InboundGet inboundGet = new InboundGet();
                    inboundGet.setNum(checkLine.getTotalNum()-total);
                    inboundGet.setSpecid(checkLine.getSpecId());
                    s.add(inboundGet);
                    checkLine.setTotalNum(0D);
                    checkLine.setStatus(EnumReceiptTask.INSSHELVES.getCode());
                    checkLineService.updateById(checkLine);
                }
            }


            // 如果所有的任务都完成了，那么就改变状态
            if ( h ==  checkLineList.size()) {
                checkHead.setStatus(EnumReceiptTask.INSSHELVES.getCode());
                checkHeadService.updateById(checkHead);
            }

            // 生成取货任务
            getlistID.add(this.cretaegetTask(s,checkHead.getCheadid()));
        }

        // 将剩下的没有放满的物品，生成放货任务
        for (OFreight f : freightList) {
            if (f.getIncreaseNum() <= 0.001) {
                continue;
            }
            putlistID.add(createputTask(f,f.getIncreaseNum()));
        }


        // 生成本次的取货任务
        TInboundHead inboundHead = new TInboundHead();
        inboundHead.setGetIdList(JSONObject.toJSONString(getlistID));
        inboundHead.setPutIdList(JSONObject.toJSONString(putlistID));
        inboundHead.setManagerName(managername);
        inboundHead.setManagerTelephone(managertelephone);
        inboundHead.setTaskNumGet(getlistID.size());
        inboundHead.setTaskNumPut(putlistID.size());
        inboundHead.setStatus(EnumInbound.NEEDGET.getCode());

        inboundHeadService.save(inboundHead);
    }

    private List<OFreight> getSPUAndSPEC(Long spuid,Long specid ) {

        // TODO
        // 容器数量
        int Fnum = 20;
        // 获取为空的容器(100个)
        LambdaQueryWrapper  wrapper = new LambdaQueryWrapper<OFreight>()
                .ge(OFreight::getSpuno,spuid)
                .ge(OFreight::getSpecid,specid)
                .gtSql(OFreight::getStocksMaxNum,"stocks_num+increase_num");
        // 分页
        Page<OFreight> page = new Page(0,Fnum);

        // 获取分页
        List<OFreight> freightList = oFreightService.page(page,wrapper).getRecords();
        if (freightList == null || freightList.size() == 0) {
            freightList = new ArrayList<>();
        }
        return freightList;
    }


    /**
     * 生成放货的任务
     * @param f
     * @param num
     */
    private Long createputTask(OFreight f, Double num) {
        TInboundPut inboundPut = new TInboundPut();
        inboundPut.setSpuId(f.getSpuno());
        inboundPut.setSpecId(f.getSpecid());
        // TODO
        inboundPut.setManagerName("默认名称");
        inboundPut.setManagerTelephone("默认电话");
        inboundPut.setItemNum(num);
        inboundPut.setWareId(f.getWareId());
        inboundPut.setResId(f.getResId());
        inboundPut.setSheId(f.getSheId());
        inboundPut.setFreId(f.getId());

        oFreightService.updateById(f);

        // 根据数量生成sku
        inboundPutService.save(inboundPut);
        return inboundPut.getId();
    }

    /**
     * 创建取货任务
     * @param list
     * @param bathcId 审核后的headid
     * @return
     */
    private Long cretaegetTask(List<InboundGet> list , String bathcId) {
        TInboundGet tInboundGet = new TInboundGet();
        tInboundGet.setBatchId(bathcId);
        tInboundGet.setManagerName("默认拿货名称");
        tInboundGet.setManagerTelephone("默认电话");
        // TODO 后期添加暂存区，后添加其他位置
        tInboundGet.setGoodList(JSONObject.toJSONString(list));
        inboundGetService.save(tInboundGet);
        return tInboundGet.getId();
    }

}
