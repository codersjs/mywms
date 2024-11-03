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
    @TableId(value = "id")
    private Long id;

    /**
     * 库区名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 库区的类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 位置
     */
    @TableField(value = "postion")
    private String postion;

    /**
     * 库区的布局
     */
    @TableField(value = "layout")
    private Object layout;

    /**
     * 仓库的长度
     */
    @TableField(value = "length")
    private Long length;

    /**
     * 库区的朝向
     */
    @TableField(value = "shedir")
    private String shedir;

    /**
     * 仓库的宽度
     */
    @TableField(value = "width")
    private Long width;

    /**
     * 仓库编号
     */
    @TableField(value = "ware_id")
    private Long wareId;

    /**
     * 库区的描述
     */
    @TableField(value = "description")
    private String description;

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