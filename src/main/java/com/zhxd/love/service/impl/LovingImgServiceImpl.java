package com.zhxd.love.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhxd.love.constant.Constant;
import com.zhxd.love.mapper.LovingImgMapper;
import com.zhxd.love.model.entity.LovingAnniversariesBackground;
import com.zhxd.love.model.entity.LovingImg;
import com.zhxd.love.model.dto.LovingImgDTO;
import com.zhxd.love.service.LovingImgService;
import com.zhxd.love.util.PictureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.service.impl
 * @Class LovingImgServiceImpl
 * @Date 2022/2/24 10:24
 */
@Service
public class LovingImgServiceImpl extends ServiceImpl<LovingImgMapper, LovingImg> implements LovingImgService {
    @Autowired
    private LovingImgMapper lovingImgMapper;

    @Override
    public List<LovingImg> getAlbumDetailById(Integer albumId) {
        List<LovingImg> imgList = this.baseMapper.getAlbumDetailById(albumId);
        String filePath =  Constant.fileDir;
        for (LovingImg lovingImg:imgList) {
            if (!lovingImg.getImgUrl().contains("http")){
                String path = filePath +  File.separator + lovingImg.getImgUrl();
                String url = PictureUtils.getImageStr(path);
                lovingImg.setImgUrl(url);
            }
        }
        return imgList;
    }

    @Override
    public void deleteByAlbumId(Integer albumId) {
        this.baseMapper.deleteByAlbumId(albumId);
    }

}