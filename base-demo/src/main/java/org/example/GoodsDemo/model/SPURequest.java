package org.example.GoodsDemo.model;

import lombok.Data;

import java.util.List;

@Data
public class SPURequest {
    private String spuname;
    private Integer defaultShelfLife;
    private List<GoodsSpecRequest> specList;
}
