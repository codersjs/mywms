package org.example.WareDemo.model;


import lombok.Data;

import java.util.List;

/**
 * 自动生成仓库的报文
 */
@Data
public class autoCreateWareRequest {
    // 仓库的名称
    private String warename;
    // 库区的数量
    private Long reseNum;
    // 仓库的长度
    private Long length;
    // 仓库的宽度
    private Long width;
    // 库区的信息
    private List<autoReservoir> reservoirs;

}
