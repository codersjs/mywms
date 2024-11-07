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
 * @TableName t_picking_line
 */
@TableName(value ="t_picking_line")
@Data
public class TPickingLine implements Serializable {
    /**
     * 拣货任务行编号
     */
    @TableId(value = "pick_line_id")
    private Long pickLineId;

    /**
     * 拣货任务头编号
     */
    @TableField(value = "pick_head_id")
    private Long pickHeadId;

    /**
     * 任务数量
     */
    @TableField(value = "task_num")
    private Double taskNum;

    /**
     * 商品名称
     */
    @TableField(value = "spu_name")
    private String spuName;

    /**
     * 规格名称
     */
    @TableField(value = "spec_name")
    private String specName;

    /**
     * 仓库名称
     */
    @TableField(value = "ware_name")
    private String wareName;

    /**
     * 库区名称
     */
    @TableField(value = "res_name")
    private String resName;

    /**
     * 货架名称
     */
    @TableField(value = "she_name")
    private String sheName;

    /**
     * 货位名称
     */
    @TableField(value = "fre_name")
    private String freName;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

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