package org.example.receiptDemo.demo;

import lombok.Data;

@Data
public class ItemRequest {
    private Long squId;
    private Long specId;
    private double getNum;
    private double totalWeight;
}
