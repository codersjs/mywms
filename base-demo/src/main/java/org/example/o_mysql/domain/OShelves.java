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
    @TableId(value = "id")
    private String id;

    /**
     * 货架名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 货架的类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 货架的位置
     */
    @TableField(value = "postion")
    private String postion;

    /**
     * 仓库编号
     */
    @TableField(value = "ware_id")
    private String wareId;

    /**
     * 库区编号
     */
    @TableField(value = "res_id")
    private String resId;

    /**
     * 库位编号
     */
    @TableField(value = "bin_id")
    private String binId;

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