package org.example.o_mysql.domain;



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
    @TableId(value = "spuno")
    private String spuno;

    /**
     * 默认保质期
     */
    @TableField(value = "default_shelf_life")
    private String defaultShelfLife;

    /**
     * 规格的种类
     */
    @TableField(value = "specification_type_list")
    private Object specificationTypeList;

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
     * 预警保质期
     */
    @TableField(value = "warn_shelf_life")
    private String warnShelfLife;

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