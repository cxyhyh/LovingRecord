package com.zhxd.love.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.model.dto
 * @Class ThingsDTO
 * @Date 2022/3/29 20:43
 */
@Data
public class ThingsDTO {

    /**
     * id
     **/
    private Integer id;

    /**
     * 事件名称
     **/
    private String name;

    /**
     * 描述
     **/
    private String describtion;

    /**
     * 地点
     **/
    private String place;

    /**
     * 状态，0：未完成，1:已完成
     **/
    private String status;

    /**
     * 图片url
     **/
    private String iconUrl;

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
