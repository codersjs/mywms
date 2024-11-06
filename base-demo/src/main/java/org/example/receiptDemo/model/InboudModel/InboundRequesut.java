package org.example.receiptDemo.model.InboudModel;

import lombok.Data;

import java.util.List;

@Data
public class InboundRequesut {
    private List<String> checkHeadList;
    private List<InboundTaskPeople> putList;
    private List<InboundTaskPeople> getList;
    private String managername;
    private String managertelephone;
}
