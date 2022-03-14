package com.zhxd.love.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhxd.love.model.entity.LovingAnniversariesBackground;
import com.zhxd.love.model.entity.LovingAnniversariesIcon;

import java.util.List;

/**
 * @author xx
 */
public interface LovingAnniversariesBackgroundService extends IService<LovingAnniversariesBackground> {

    List<LovingAnniversariesBackground> getList();
}
