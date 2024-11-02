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
    @TableId
    private String skuno;

    /**
     * 物品的种类
     */
    private String spuno;

    /**
     * 物品的规格
     */
    private String specification;

    /**
     * 生产日期
     */
    private Date date_manufacture;

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