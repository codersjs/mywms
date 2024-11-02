package org.example.o_mysql.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
    @TableId
    private String spcid;

    /**
     * 物品的种类
     */
    private String spuno;

    /**
     * 规格名称
     */
    private String spc_name;

    /**
     * 存储容量
     */
    private Long stock_max_num;

    /**
     * 存储形式
     */
    private Long stock_type;

    /**
     * 存储描述
     */
    private Long stock_message;

    /**
     * 总的数量
     */
    private Double total_quantity;

    /**
     * 可用数量
     */
    private Double available_quantity;

    /**
     * 预警总数量
     */
    private Double warn_total_num;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer is_delete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}