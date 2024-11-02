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
 * @TableName o_shelves_type
 */
@TableName(value ="o_shelves_type")
@Data
public class OShelvesType implements Serializable {
    /**
     * 货架编号
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 货架名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 货架的层数
     */
    @TableField(value = "layer")
    private Long layer;

    /**
     * 货架每行的货位容量
     */
    @TableField(value = "layer_num")
    private Long layerNum;

    /**
     * 货架的描述
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