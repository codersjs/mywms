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
 * @TableName t_receipt_line
 */
@TableName(value ="t_receipt_line")
@Data
public class TReceiptLine implements Serializable {
    /**
     * 批次号
     */
    @TableId(value = "batch_id")
    private String batchId;

    /**
     * 收货单头id
     */
    @TableField(value = "rhead_id")
    private String rheadId;

    /**
     * 检验单头
     */
    @TableField(value = "check_head_id")
    private String checkHeadId;

    /**
     * 状态
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
     * 收货单物品的编号
     */
    @TableField(value = "item_list")
    private Object itemList;

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