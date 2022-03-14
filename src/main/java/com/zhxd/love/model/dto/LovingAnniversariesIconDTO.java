package com.zhxd.love.model.dto;


import lombok.Data;
import lombok.experimental.Accessors;
import java.util.*;

/**
 * 纪念日图标表
 *
 * @author hyh
 * @date 2022-03-04 11:01:44
 */
@Data
@Accessors(chain = true)
public class LovingAnniversariesIconDTO{

    /**
     * 
     */
    private Integer id;
    /**
     * 图标名称
     */
    private String name;
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