package com.zhxd.love.mapper;

import com.zhxd.love.model.entity.LovingAnniversaries;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author hyh
 */
public interface LovingAnniversariesMapper extends BaseMapper<LovingAnniversaries> {

    List<LovingAnniversaries> getByName(String name);

    List<LovingAnniversaries> getAll();
}
