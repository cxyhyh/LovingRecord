package com.zhxd.love.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.model.entity
 * @Class Things
 * @Date 2022/3/29 20:31
 */
@Data
@TableName("100things")
public class Things {

    /**
     * id
     **/
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 事件名称
     **/
    @TableField(value = "name")
    private String name;

    /**
     * 描述
     **/
    @TableField(value = "describtion")
    private String describtion;

    /**
     * 地点
     **/
    @TableField(value = "place")
    private String place;

    /**
     * 状态，0：未完成，1:已完成
     **/
    @TableField(value = "status")
    private String status;

    /**
     * 图片url
     **/
    @TableField(value = "icon_url")
    private String iconUrl;

    /**
     * 创建者
     */
    @TableField(value = "create_by",exist = true  )
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "create_date",exist = true  )
    private Date createDate;

    /**
     * 更新者
     */
    @TableField(value = "update_by",exist = true  )
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "update_date",exist = true  )
    private Date updateDate;

    /**
     * 备注信息
     */
    @TableField(value = "remarks",exist = true  )
    private String remarks;

    /**
     * 删除标记（0：正常；1：删除）
     */
    @TableField(value = "del_flag",exist = true  )
    private String delFlag;

}
