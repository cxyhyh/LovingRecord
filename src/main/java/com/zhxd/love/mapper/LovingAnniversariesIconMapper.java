package com.zhxd.love.mapper;

import com.zhxd.love.model.entity.LovingAnniversariesIcon;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author hyh
 */
public interface LovingAnniversariesIconMapper extends BaseMapper<LovingAnniversariesIcon> {

    List<LovingAnniversariesIcon> getList();
}
