package org.example.GoodsDemo.model;

import lombok.Data;

@Data
public class GoodsSpecRequest {
    private String specName;
    private String stockType;
    private Double stockMaxNum;
        private String numunit;
}
