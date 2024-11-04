package org.example.receiptDemo.demo;

import lombok.Data;

import java.util.List;

@Data
public class BatchRequest {
    private List<ItemRequest> list;
}
