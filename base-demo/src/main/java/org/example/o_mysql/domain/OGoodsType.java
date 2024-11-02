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
 * @TableName o_goods_type
 */
@TableName(value ="o_goods_type")
@Data
public class OGoodsType implements Serializable {
    /**
     * 物品的种类
     */
    @TableId
    private String spuno;

    /**
     * 默认保质期
     */
    private String default_shelf_life;

    /**
     * 规格的种类
     */
    private Object specification_type_list;

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
     * 预警保质期
     */
    private String warn_shelf_life;

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