package com.zhxd.love.model.dto;


import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.*;

/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.model.dto
 * @Class LovingAlbumDTO
 * @Date 2022/2/24 10:24
 */
@Data
@Accessors(chain = true)
public class LovingAlbumDTO{

    /**
     * id
     */
    private Integer id;
    /**
     * 相册名称
     */
    private String albumName;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 照片数量
     */
    private String pictureNum;
    /**
     * 视频数量
     */
    private String videoNum;

    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 删除标记（0：正常；1：删除）
     */
    private String delFlag;

}