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
 * @TableName o_goods_unit
 */
@TableName(value ="o_goods_unit")
@Data
public class OGoodsUnit implements Serializable {
    /**
     * 物品最小存储单元
     */
    @TableId(value = "skuno")
    private Long skuno;

    /**
     * 物品名称
     */
    @TableField(value = "skuno_name")
    private String skunoName;

    /**
     * 物品的种类
     */
    @TableField(value = "spuno")
    private Long spuno;

    /**
     * 物品的规格
     */
    @TableField(value = "spec_id")
    private Long specId;

    /**
     * 生产日期
     */
    @TableField(value = "date_manufacture")
    private Date dateManufacture;

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