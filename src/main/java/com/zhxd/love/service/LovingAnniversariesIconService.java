package com.zhxd.love.service;

import com.zhxd.love.model.entity.LovingAnniversariesIcon;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhxd.love.util.Result;

import java.util.List;

/**
 * @author hyh
 */
public interface LovingAnniversariesIconService extends IService<LovingAnniversariesIcon> {

    List<LovingAnniversariesIcon> getList();
}
