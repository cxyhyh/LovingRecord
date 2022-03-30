package com.zhxd.love.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhxd.love.constant.Constant;
import com.zhxd.love.mapper.LovingAnniversariesMapper;
import com.zhxd.love.model.entity.LovingAnniversaries;
import com.zhxd.love.model.dto.LovingAnniversariesDTO;
import com.zhxd.love.model.entity.LovingImg;
import com.zhxd.love.service.LovingAnniversariesService;
import com.zhxd.love.util.PictureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author hyh
 */
@Service
public class LovingAnniversariesServiceImpl extends ServiceImpl<LovingAnniversariesMapper, LovingAnniversaries> implements LovingAnniversariesService {
    @Autowired
    private LovingAnniversariesMapper lovingAnniversariesMapper;

    @Override
    public boolean saveAnniversaries(LovingAnniversaries lovingAnniversaries) {
        Date date = new Date();
        lovingAnniversaries.setCreateDate(date);
        lovingAnniversaries.setUpdateDate(date);
        this.save(lovingAnniversaries);
        return true;
    }

    @Override
    public List<LovingAnniversaries> getByName(String name) {
        return this.baseMapper.getByName(name);
    }

    @Override
    public List<LovingAnniversaries> getAll() {
        List<LovingAnniversaries> lovingAnniversariesList =  this.baseMapper.getAll();
        String filePath =  Constant.fileDir;
        for (LovingAnniversaries lovingAnniversaries:lovingAnniversariesList) {
            if (!lovingAnniversaries.getIconUrl().contains("http")){
                String path = filePath  + lovingAnniversaries.getIconUrl();
                String url = PictureUtils.getImageStr(path);
                lovingAnniversaries.setIconUrl(url);
            }
            if (!lovingAnniversaries.getBackgroundUrl().contains("http")){
                String path = filePath  + lovingAnniversaries.getBackgroundUrl();
                String url = PictureUtils.getImageStr(path);
                lovingAnniversaries.setBackgroundUrl(url);
            }
        }
        return lovingAnniversariesList;
    }
}