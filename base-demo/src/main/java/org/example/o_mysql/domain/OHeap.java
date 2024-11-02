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
 * @TableName o_heap
 */
@TableName(value ="o_heap")
@Data
public class OHeap implements Serializable {
    /**
     * 堆货区编号
     */
    @TableId
    private String id;

    /**
     * 堆货区名称
     */
    private String name;

    /**
     * 堆货区的类型
     */
    private String type;

    /**
     * 位置
     */
    private String postion;

    /**
     * 仓库编号
     */
    private String ware_id;

    /**
     * 库区编号
     */
    private String res_id;

    /**
     * 堆货区的描述
     */
    private String dec;

    /**
     * 是否锁定
     */
    private Integer is_lock;

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