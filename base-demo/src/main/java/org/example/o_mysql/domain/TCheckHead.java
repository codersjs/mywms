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
 * @TableName t_check_head
 */
@TableName(value ="t_check_head")
@Data
public class TCheckHead implements Serializable {
    /**
     * 检验单头
     */
    @TableId(value = "cheadid")
    private String cheadid;

    /**
     * 批次号
     */
    @TableField(value = "batch_id")
    private String batchId;

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
     * 状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 状态
     */
    @TableField(value = "report")
    private String report;

    /**
     * 检验单行
     */
    @TableField(value = "check_line_list")
    private Object checkLineList;

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