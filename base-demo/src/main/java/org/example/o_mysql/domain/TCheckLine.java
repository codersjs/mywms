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
 * @TableName t_check_line
 */
@TableName(value ="t_check_line")
@Data
public class TCheckLine implements Serializable {
    /**
     * 检验单头
     */
    @TableId(value = "cheadid")
    private Long cheadid;

    /**
     * 批次号
     */
    @TableField(value = "batch_id")
    private Long batchId;

    /**
     * spuid
     */
    @TableField(value = "spu_id")
    private Long spuId;

    /**
     * 规格id
     */
    @TableField(value = "spec_id")
    private Long specId;

    /**
     * 操作人姓名
     */
    @TableField(value = "operate_name")
    private String operateName;

    /**
     * 操作人人电话
     */
    @TableField(value = "operate_telephone")
    private String operateTelephone;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 总数量
     */
    @TableField(value = "total_num")
    private Double totalNum;

    /**
     * 数量的单位
     */
    @TableField(value = "unit_num")
    private String unitNum;

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