package org.example.o_mysql.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName o_heap
 */
@TableName(value ="o_heap")
@Data
public class OHeap implements Serializable {
    /**
     * 堆货区编号
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 堆货区名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 堆货区的类型
     */
    @TableField(value = "type_id")
    private Long typeId;

    /**
     * 位置
     */
    @TableField(value = "postion")
    private String postion;

    /**
     * 仓库编号
     */
    @TableField(value = "ware_id")
    private Long wareId;

    /**
     * 库区编号
     */
    @TableField(value = "res_id")
    private Long resId;

    /**
     * 堆货区的描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 是否锁定
     */
    @TableField(value = "is_lock")
    private Integer isLock;

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
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}