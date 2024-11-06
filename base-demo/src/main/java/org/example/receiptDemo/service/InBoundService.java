package org.example.receiptDemo.service;

import org.example.receiptDemo.model.InboudModel.InboundTaskPeople;

import java.util.List;

public interface InBoundService {
    void createInboundTask(List<String> checkHeadList, List<InboundTaskPeople> getList, List<InboundTaskPeople> putList, String managername, String managertelephone);
}
