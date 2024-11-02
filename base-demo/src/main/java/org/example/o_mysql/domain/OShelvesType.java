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
    @TableId
    private String id;

    /**
     * 货架名称
     */
    private String name;

    /**
     * 货架的层数
     */
    private Long layer;

    /**
     * 货架每行的货位容量
     */
    private Long layer_num;

    /**
     * 货架的描述
     */
    private String dec;

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