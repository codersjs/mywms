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
 * @TableName t_issue_head
 */
@TableName(value ="t_issue_head")
@Data
public class TIssueHead implements Serializable {
    /**
     * 发货单编号
     */
    @TableId(value = "iss_head_id")
    private Long issHeadId;

    /**
     * 收货人名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 收货人电话
     */
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 收货最终地址
     */
    @TableField(value = "address")
    private String address;

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
    @TableField(value = "issue_line_list")
    private Object issueLineList;

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