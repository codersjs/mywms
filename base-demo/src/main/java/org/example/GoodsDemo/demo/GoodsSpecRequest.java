package org.example.GoodsDemo.demo;

import lombok.Data;

@Data
public class GoodsSpecRequest {
    private String specName;
    private String stockType;
    private Double stockMaxNum;
}
