package org.example.IssueDemo.service.Impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.IssueDemo.model.IssueLineRequest;
import org.example.IssueDemo.model.IssueRequest;
import org.example.IssueDemo.service.IssueService;
import org.example.o_mysql.domain.OGoodsSpecification;
import org.example.o_mysql.domain.TIssueHead;
import org.example.o_mysql.domain.TIssueLine;
import org.example.o_mysql.service.OGoodsSpecificationService;
import org.example.o_mysql.service.TIssueHeadService;
import org.example.o_mysql.service.TIssueLineService;
import org.example.utilAndCommonDemo.Enum.EnumIssue;
import org.example.utilAndCommonDemo.Exception.BusinessException;
import org.example.utilAndCommonDemo.unit.IDcreate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Resource
    private TIssueHeadService issueHeadService;
    @Resource
    private TIssueLineService issueLineService;

    @Resource
    private OGoodsSpecificationService oGoodsSpecificationService;

    @Override
    @Transactional
    public void createIssue(IssueRequest request) {
        // 进行检验
        this.check(request);

        TIssueHead issueHead = new TIssueHead();
        issueHead.setAddress(request.getAddresss());
        issueHead.setName(request.getName());
        issueHead.setTelephone(request.getTelephne());
        issueHead.setStatus(EnumIssue.New.getCode());
        List<IssueLineRequest> list = request.getList();
        List<Long> lineIds = new ArrayList<>();

        for (IssueLineRequest requestLine : list) {
            TIssueLine tissueLine = new TIssueLine();
            tissueLine.setIssLineId(IDcreate.getLongIdMIN6());
            tissueLine.setSpuid(requestLine.getSpuid());
            tissueLine.setSpecid(requestLine.getSpecid());
            tissueLine.setGetNum(requestLine.getNum());
            tissueLine.setStatus(EnumIssue.New.getCode());
            lineIds.add(IDcreate.getLongIdMIN6());
            issueLineService.save(tissueLine);
        }

        issueHead.setIssueLineList(JSONObject.toJSONString(lineIds));
        issueHeadService.save(issueHead);
    }

    /**
     * 进行检验判断是否可以生产订单
     * @param request
     */
    private void check(IssueRequest request) {

        List<IssueLineRequest> list = request.getList();
        // 1. 查询数量是否足够
        for (IssueLineRequest requestLine : list) {
            Long specid = requestLine.getSpecid();
            changespecNum(specid,requestLine.getNum());
            // 亮点redis的分布式锁
        }
        // 2.

    }

    /**
     * 改变数量
     * @param
     */
    // TODO 后期改成分布式锁
    private synchronized void changespecNum(Long specid, Double num) {
        OGoodsSpecification oGoodsSpecification = oGoodsSpecificationService.getById(specid);
        if (oGoodsSpecification == null) {
            throw new BusinessException(specid+"所购买的物品不存在");
        }
        if (oGoodsSpecification.getAvailableQuantity() - num >= 0)
            oGoodsSpecification.setAvailableQuantity(oGoodsSpecification.getAvailableQuantity() - num);
        else
            throw new BusinessException("数量不足不能发货");
        oGoodsSpecificationService.updateById(oGoodsSpecification);
    }

}
