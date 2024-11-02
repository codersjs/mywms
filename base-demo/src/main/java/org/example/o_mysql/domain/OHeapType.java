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
    @TableId
    private String id;

    /**
     * 货区名称
     */
    private String name;

    /**
     * 堆货区的长度
     */
    private Long length;

    /**
     * 堆货区的宽度
     */
    private Long width;

    /**
     * 堆货区的描述
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