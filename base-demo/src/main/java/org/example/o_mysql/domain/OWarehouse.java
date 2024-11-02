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
 * @TableName o_warehouse
 */
@TableName(value ="o_warehouse")
@Data
public class OWarehouse implements Serializable {
    /**
     * 仓库编号
     */
    @TableId(value = "id")
    private String id;

    /**
     * 仓库名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 仓库的类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 仓库的布局
     */
    @TableField(value = "layout")
    private Object layout;

    /**
     * 仓库的长度
     */
    @TableField(value = "length")
    private Long length;

    /**
     * 仓库的宽度
     */
    @TableField(value = "width")
    private Long width;

    /**
     * 仓库的地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 仓库的描述
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