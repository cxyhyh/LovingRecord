package com.zhxd.love.model.dto;


import lombok.Data;
import lombok.experimental.Accessors;
import java.util.*;

/**
 * 纪念日背景图片表
 *
 * @author xx
 * @date 2022-03-04 17:49:12
 */
@Data
@Accessors(chain = true)
public class LovingAnniversariesBackgroundDTO{

    /**
     * 
     */
    private Integer id;
    /**
     * 图片url
     */
    private String url;
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