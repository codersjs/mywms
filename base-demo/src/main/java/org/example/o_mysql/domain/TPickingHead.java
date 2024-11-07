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
 * @TableName t_picking_head
 */
@TableName(value ="t_picking_head")
@Data
public class TPickingHead implements Serializable {
    /**
     * 拣货任务头编号
     */
    @TableId(value = "pick_head_id")
    private Long pickHeadId;

    /**
     * 发货单编号
     */
    @TableField(value = "iss_head_id")
    private Long issHeadId;

    /**
     * 任务完成数量
     */
    @TableField(value = "finish_task")
    private Integer finishTask;

    /**
     * 任务数量
     */
    @TableField(value = "task_num")
    private Integer taskNum;

    /**
     * 任务id
     */
    @TableField(value = "pick_line_list")
    private Object pickLineList;

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