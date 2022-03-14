package com.zhxd.love.model.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;

/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.model.entity
 * @Class LovingAlbum
 * @Date 2022/2/24 10:24
 */
@Data
@Accessors(chain = true)
@TableName(value = "loving_album")
public class LovingAlbum extends Model<LovingAlbum> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 相册名称
     */
    @TableField(value = "album_name",exist = true  )
    private String albumName;
    /**
     * 用户id
     */
    @TableField(value = "user_id",exist = true  )
    private Integer userId;
    /**
     * 图片数量
     */
    @TableField(value = "picture_num",exist = true  )
    private String pictureNum;
    /**
     * 视频数量
     */
    @TableField(value = "video_num",exist = true  )
    private String videoNum;

    @TableField(value = "img_first",exist = true)
    private String imgFirst;

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