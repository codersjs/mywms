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
 * @TableName t_receipt_item
 */
@TableName(value ="t_receipt_item")
@Data
public class TReceiptItem implements Serializable {
    /**
     * 收货单头id
     */
    @TableId(value = "ritem_id")
    private Long ritemId;

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
     * 总数量
     */
    @TableField(value = "get_num")
    private Double getNum;

    /**
     * 数量的单位
     */
    @TableField(value = "unit_num")
    private String unitNum;

    /**
     * 单位重量
     */
    @TableField(value = "unit_weight")
    private Double unitWeight;

    /**
     * 总重量
     */
    @TableField(value = "total_weight")
    private Double totalWeight;

    /**
     * 检验单行
     */
    @TableField(value = "check_line_id")
    private Long checkLineId;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 结束时间
     */
    @TableField(value = "endTime")
    private Date endtime;

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