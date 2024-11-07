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
 * @TableName t_issue_line
 */
@TableName(value ="t_issue_line")
@Data
public class TIssueLine implements Serializable {
    /**
     * 行编号
     */
    @TableId(value = "iss_line_id")
    private Long issLineId;

    /**
     * 商品id
     */
    @TableField(value = "spuid")
    private Long spuid;

    /**
     * 规格id
     */
    @TableField(value = "specid")
    private Long specid;

    /**
     * 任务数量
     */
    @TableField(value = "get_num")
    private Double getNum;

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