package org.example.receiptDemo.model.ReceiptModel;

import lombok.Data;

@Data
public class ItemRequest {
    private Long spuId;
    private Long specId;
    private Double getNum;
    private Double totalWeight;
}
