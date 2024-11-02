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
 * @TableName o_heap_type
 */
@TableName(value ="o_heap_type")
@Data
public class OHeapType implements Serializable {
    /**
     * 堆区id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 货区名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 堆货区的长度
     */
    @TableField(value = "length")
    private Long length;

    /**
     * 堆货区的宽度
     */
    @TableField(value = "width")
    private Long width;

    /**
     * 堆货区的描述
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