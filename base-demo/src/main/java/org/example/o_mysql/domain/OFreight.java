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
 * @TableName o_freight
 */
@TableName(value ="o_freight")
@Data
public class OFreight implements Serializable {
    /**
     * 货架编号
     */
    @TableId
    private String id;

    /**
     * 货架名称
     */
    private String name;

    /**
     * 货位的X坐标
     */
    private Long x;

    /**
     * 货位的Y坐标
     */
    private Long y;

    /**
     * 货位的Z坐标
     */
    private Long z;

    /**
     * 货位存放的物品的类型
     */
    private String spuno;

    /**
     * 货位的存货数量
     */
    private Long stocks_num;

    /**
     * 货位最大容量
     */
    private Long stocks_max_num;

    /**
     * 仓库编号
     */
    private String ware_id;

    /**
     * 库区编号
     */
    private String res_id;

    /**
     * 货架编号
     */
    private String she_id;

    /**
     * 货位的描述
     */
    private String dec;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer is_delete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}