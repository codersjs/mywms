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
    @TableId
    private String id;

    /**
     * 仓库名称
     */
    private String name;

    /**
     * 仓库的类型
     */
    private String type;

    /**
     * 仓库的布局
     */
    private Object layout;

    /**
     * 仓库的长度
     */
    private Long length;

    /**
     * 仓库的宽度
     */
    private Long width;

    /**
     * 仓库的地址
     */
    private String address;

    /**
     * 仓库的描述
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