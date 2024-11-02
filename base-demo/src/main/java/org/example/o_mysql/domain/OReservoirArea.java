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
 * @TableName o_reservoir_area
 */
@TableName(value ="o_reservoir_area")
@Data
public class OReservoirArea implements Serializable {
    /**
     * 库区编号
     */
    @TableId
    private String id;

    /**
     * 库区名称
     */
    private String name;

    /**
     * 库区的类型
     */
    private String type;

    /**
     * 位置
     */
    private String postion;

    /**
     * 库区的布局
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
     * 仓库编号
     */
    private String ware_id;

    /**
     * 库区的描述
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