package com.zhxd.love.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhxd.love.constant.Constant;
import com.zhxd.love.mapper.LovingAlbumMapper;
import com.zhxd.love.mapper.LovingImgMapper;
import com.zhxd.love.model.entity.LovingAlbum;
import com.zhxd.love.model.entity.LovingImg;
import com.zhxd.love.service.LovingAlbumService;
import com.zhxd.love.util.PictureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.service.impl
 * @Class LovingAlbumServiceImpl
 * @Date 2022/2/24 10:24
 */
@Service
public class LovingAlbumServiceImpl extends ServiceImpl<LovingAlbumMapper, LovingAlbum> implements LovingAlbumService {
    @Autowired
    private LovingAlbumMapper lovingAlbumMapper;
    @Autowired
    private LovingImgMapper lovingImgMapper;



    @Override
    public LovingAlbum getByName(String albumName) {
        return this.baseMapper.getByName(albumName);
    }

    @Override
    public List<LovingAlbum> getByUser(Integer userId) {

        List<LovingAlbum> lovingAlbumList = this.baseMapper.getByUser(userId);
        String filePath =  Constant.fileDir;
        for (LovingAlbum lovingAlbum:lovingAlbumList) {
            if (!lovingAlbum.getImgFirst().contains("http")){
                String path = filePath +  File.separator + lovingAlbum.getImgFirst();
                String url = PictureUtils.getImageStr(path);
                lovingAlbum.setImgFirst(url);
            }
        }
        return lovingAlbumList;
    }

    @Override
    public LovingAlbum getPictureAndVideoNUm(String albumName) {
        return this.baseMapper.getPictureAndVideoNUm(albumName);
    }

    @Override
    public Integer getIdByName(String albumName) {
        return this.baseMapper.getIdByName(albumName);
    }

    @Override
    public String getNameById(Integer id) {
        return this.baseMapper.getNameById(id);
    }

}