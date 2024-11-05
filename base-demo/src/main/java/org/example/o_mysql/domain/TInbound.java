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
 * @TableName t_inbound
 */
@TableName(value ="t_inbound")
@Data
public class TInbound implements Serializable {
    /**
     * 入库单的头
     */
    @TableId(value = "id")
    private Long id;

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
     * sku的idList
     */
    @TableField(value = "item_list")
    private Object itemList;

    /**
     * 总数量
     */
    @TableField(value = "item_num")
    private Double itemNum;

    /**
     * 仓库编号
     */
    @TableField(value = "ware_id")
    private Long wareId;

    /**
     * 库区编号
     */
    @TableField(value = "res_id")
    private Long resId;

    /**
     * 货架编号
     */
    @TableField(value = "she_id")
    private Long sheId;

    /**
     * 货位编号
     */
    @TableField(value = "fre_id")
    private Long freId;

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