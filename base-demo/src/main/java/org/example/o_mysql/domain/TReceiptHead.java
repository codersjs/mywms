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
 * @TableName t_receipt_head
 */
@TableName(value ="t_receipt_head")
@Data
public class TReceiptHead implements Serializable {
    /**
     * 收货单头id
     */
    @TableId(value = "rhead_id")
    private String rheadId;

    /**
     * 订单来源
     */
    @TableField(value = "source")
    private String source;

    /**
     * 负责人姓名
     */
    @TableField(value = "manager_name")
    private String managerName;

    /**
     * 负责人电话
     */
    @TableField(value = "manager_telephone")
    private String managerTelephone;

    /**
     * 订单状态
     */
    @TableField(value = "status")
    private String status;

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
     * 批次id
     */
    @TableField(value = "batch_list")
    private Object batchList;

    /**
     * 结束时间
     */
    @TableField(value = "endTime")
    private Date endtime;

    /**
     * 描述
     */
    @TableField(value = "message")
    private Long message;

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