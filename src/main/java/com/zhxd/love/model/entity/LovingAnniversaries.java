package com.zhxd.love.model.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 纪念日表
 *
 * @author hyh
 * @date 2022-03-03 16:27:42
 */
@Data
@Accessors(chain = true)
@TableName(value = "loving_anniversaries")
public class LovingAnniversaries extends Model<LovingAnniversaries> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 纪念日名称
     */
    //@NotBlank(message = "纪念日名称不能为空")
    @TableField(value = "name",exist = true  )
    private String name;
    /**
     * 纪念日期
     */
    //@NotEmpty(message = "纪念日期不能为空")
    @TableField(value = "timeStr",exist = true  )
    private String timestr;
    /**
     * 背景url
     */
    //@NotEmpty(message = "背景不能为空")
    @TableField(value = "background_url",exist = true  )
    private String backgroundUrl;
    /**
     * 图标url
     */
    //@NotEmpty(message = "图标不能为空")
    @TableField(value = "icon_url",exist = true  )
    private String iconUrl;
    /**
     * 创建时间
     */
    @TableField(value = "create_date",exist = true  )
    private Date createDate;
    /**
     * 创建人员
     */
    @TableField(value = "create_by",exist = true  )
    private String createBy;
    /**
     * 修改时间
     */
    @TableField(value = "update_date",exist = true  )
    private Date updateDate;
    /**
     * 修改人员
     */
    @TableField(value = "update_by",exist = true  )
    private String updateBy;
    /**
     * 备注
     */
    @TableField(value = "remarks",exist = true  )
    private String remarks;
    /**
     * 
     */
    @TableField(value = "del_flag",exist = true  )
    private String delFlag;

}