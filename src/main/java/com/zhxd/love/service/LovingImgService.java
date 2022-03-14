package com.zhxd.love.service;

import com.zhxd.love.model.entity.LovingImg;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.service
 * @Class LovingImgService
 * @Date 2022/2/24 10:24
 */
public interface LovingImgService extends IService<LovingImg> {

    List<LovingImg> getAlbumDetailById(Integer albumId);

    void deleteByAlbumId(Integer albumId);
}
