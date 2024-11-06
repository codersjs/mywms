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
 * @TableName t_inbound_head
 */
@TableName(value ="t_inbound_head")
@Data
public class TInboundHead implements Serializable {
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
     * 取货的id列
     */
    @TableField(value = "get_id_list")
    private Object getIdList;

    /**
     * 放货的id列
     */
    @TableField(value = "put_id_list")
    private Object putIdList;

    /**
     * 取货的任务完成数量
     */
    @TableField(value = "finish_task_get")
    private Integer finishTaskGet;

    /**
     * 取货任务数量
     */
    @TableField(value = "task_num_get")
    private Integer taskNumGet;

    /**
     * 放货的任务完成数量
     */
    @TableField(value = "finish_task_put")
    private Integer finishTaskPut;

    /**
     * 放货任务数量
     */
    @TableField(value = "task_num_put")
    private Integer taskNumPut;

    /**
     * 规格id
     */
    @TableField(value = "spec_id")
    private Long specId;

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