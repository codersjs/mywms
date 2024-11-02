package org.example.autoCreateWareDemo.model;

import lombok.Data;

import java.util.List;

/**
 * 自动生成库区
 */
@Data
public class autoReservoir {
    // 库区的名称
    private String name;
    // 库区的宽度
    private Long width;
    // 库区的长度
    private Long length;
    // 库区左上角的X坐标
    private Long postionX;
    // 库区左上角的Y坐标
    private Long postionY;
    // 货架朝向
    private String direction;
    // 货位信息
    private List<autoshelves> autoshelvesList;
}
