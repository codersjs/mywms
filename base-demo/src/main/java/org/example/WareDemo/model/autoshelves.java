package org.example.WareDemo.model;

import lombok.Data;

/**
 * 自动生成货架
 */
@Data
public class autoshelves {
    // 是否是货架
    private String istypenum;
    // 存储单元的编号
    private Long typeId;
    // 上到下，左到右，左上的坐标
    private Long postionX;
    private Long postionY;
}
