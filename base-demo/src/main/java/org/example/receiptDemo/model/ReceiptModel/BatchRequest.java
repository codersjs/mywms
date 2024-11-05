package org.example.receiptDemo.model.ReceiptModel;

import lombok.Data;

import java.util.List;

@Data
public class BatchRequest {
    private List<ItemRequest> list;
}
