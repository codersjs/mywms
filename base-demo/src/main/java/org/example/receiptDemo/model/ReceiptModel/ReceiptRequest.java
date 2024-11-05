package org.example.receiptDemo.model.ReceiptModel;

import lombok.Data;

import java.util.List;

@Data
public class ReceiptRequest {

    private String source;
    private String name;
    private String telephone;
    private List<BatchRequest> list;
}
