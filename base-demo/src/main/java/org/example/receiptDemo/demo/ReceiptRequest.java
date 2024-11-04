package org.example.receiptDemo.demo;

import lombok.Data;

import java.util.List;

@Data
public class ReceiptRequest {

    private String source;
    private List<BatchRequest> list;
}
