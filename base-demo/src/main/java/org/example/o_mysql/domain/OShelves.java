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
 * @TableName o_shelves
 */
@TableName(value ="o_shelves")
@Data
public class OShelves implements Serializable {
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
     * 货架的类型
     */
    private String type;

    /**
     * 货架的位置
     */
    private String postion;

    /**
     * 仓库编号
     */
    private String ware_id;

    /**
     * 库区编号
     */
    private String res_id;

    /**
     * 库位编号
     */
    private String bin_id;

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