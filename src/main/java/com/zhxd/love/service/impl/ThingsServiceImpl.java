package com.zhxd.love.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhxd.love.mapper.ThingsMapper;
import com.zhxd.love.model.entity.Things;
import com.zhxd.love.service.ThingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.service.impl
 * @Class ThingsServiceImpl
 * @Date 2022/3/29 20:54
 */
@Service
public class ThingsServiceImpl extends ServiceImpl<ThingsMapper,Things> implements ThingsService{

    @Autowired
    private ThingsMapper thingsMapper;

}
