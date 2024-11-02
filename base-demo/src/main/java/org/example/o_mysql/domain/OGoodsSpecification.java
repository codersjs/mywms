package org.example.o_mysql.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName o_goods_specification
 */
@TableName(value ="o_goods_specification")
@Data
public class OGoodsSpecification implements Serializable {
    /**
     * 规格id
     */
    @TableId(value = "spcid")
    private String spcid;

    /**
     * 物品的种类
     */
    @TableField(value = "spuno")
    private String spuno;

    /**
     * 规格名称
     */
    @TableField(value = "spc_name")
    private String spcName;

    /**
     * 存储容量
     */
    @TableField(value = "stock_max_num")
    private Long stockMaxNum;

    /**
     * 存储形式
     */
    @TableField(value = "stock_type")
    private Long stockType;

    /**
     * 存储描述
     */
    @TableField(value = "stock_message")
    private Long stockMessage;

    /**
     * 总的数量
     */
    @TableField(value = "total_quantity")
    private Double totalQuantity;

    /**
     * 可用数量
     */
    @TableField(value = "available_quantity")
    private Double availableQuantity;

    /**
     * 预警总数量
     */
    @TableField(value = "warn_total_num")
    private Double warnTotalNum;

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