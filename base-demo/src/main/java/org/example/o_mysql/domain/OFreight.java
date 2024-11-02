package org.example.o_mysql.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName o_freight
 */
@TableName(value ="o_freight")
@Data
public class OFreight implements Serializable {
    /**
     * 货架编号
     */
    @TableId(value = "id")
    private String id;

    /**
     * 货架名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 货位的X坐标
     */
    @TableField(value = "x")
    private Long x;

    /**
     * 货位的Y坐标
     */
    @TableField(value = "y")
    private Long y;

    /**
     * 货位的Z坐标
     */
    @TableField(value = "z")
    private Long z;

    /**
     * 货位存放的物品的类型
     */
    @TableField(value = "spuno")
    private String spuno;

    /**
     * 货位的存货数量
     */
    @TableField(value = "stocks_num")
    private Long stocksNum;

    /**
     * 货位最大容量
     */
    @TableField(value = "stocks_max_num")
    private Long stocksMaxNum;

    /**
     * 仓库编号
     */
    @TableField(value = "ware_id")
    private String wareId;

    /**
     * 库区编号
     */
    @TableField(value = "res_id")
    private String resId;

    /**
     * 货架编号
     */
    @TableField(value = "she_id")
    private String sheId;

    /**
     * 货位的描述
     */
    @TableField(value = "dec")
    private String dec;

    /**
     * 创建时间
     */
    @TableField(value = "createTime")
    private Date createtime;

    /**
     * 更新时间
     */
    @TableField(value = "updateTime")
    private Date updatetime;

    /**
     * 是否删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}