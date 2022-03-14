package com.zhxd.love.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhxd.love.mapper.LovingAnniversariesIconMapper;
import com.zhxd.love.model.entity.LovingAnniversariesIcon;
import com.zhxd.love.model.dto.LovingAnniversariesIconDTO;
import com.zhxd.love.service.LovingAnniversariesIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author hyh
 */
@Service
public class LovingAnniversariesIconServiceImpl extends ServiceImpl<LovingAnniversariesIconMapper, LovingAnniversariesIcon> implements LovingAnniversariesIconService {
    @Autowired
    private LovingAnniversariesIconMapper lovingAnniversariesIconMapper;

    @Override
    public List<LovingAnniversariesIcon> getList() {
        return this.baseMapper.getList();
    }
}