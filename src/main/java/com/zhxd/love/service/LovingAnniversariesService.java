package com.zhxd.love.service;

import com.zhxd.love.model.entity.LovingAnniversaries;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author hyh
 */
public interface LovingAnniversariesService extends IService<LovingAnniversaries> {

    boolean saveAnniversaries(LovingAnniversaries lovingAnniversaries);

    List<LovingAnniversaries> getByName(String name);
}
