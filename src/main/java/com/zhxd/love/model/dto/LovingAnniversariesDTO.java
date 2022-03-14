package com.zhxd.love.model.dto;


import lombok.Data;
import lombok.experimental.Accessors;
import java.util.*;

/**
 * 纪念日表
 *
 * @author hyh
 * @date 2022-03-03 16:27:42
 */
@Data
@Accessors(chain = true)
public class LovingAnniversariesDTO{

    /**
     * 
     */
    private Integer id;
    /**
     * 纪念日名称
     */
    private String name;
    /**
     * 纪念日期
     */
    private String timestr;
    /**
     * 背景url
     */
    private String backgroundUrl;
    /**
     * 图标url
     */
    private String iconUrl;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 创建人员
     */
    private String createBy;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 修改人员
     */
    private String updateBy;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 
     */
    private String delFlag;

}