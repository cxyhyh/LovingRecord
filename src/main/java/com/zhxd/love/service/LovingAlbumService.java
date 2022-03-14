package com.zhxd.love.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhxd.love.model.entity.LovingAlbum;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.service
 * @Class LovingAlbumService
 * @Date 2022/2/24 10:24
 */
public interface LovingAlbumService extends IService<LovingAlbum> {

    LovingAlbum getByName(String albumName);

    List<LovingAlbum> getByUser(Integer userId);

    LovingAlbum getPictureAndVideoNUm(String albumName);

    Integer getIdByName(String albumName);

    String getNameById(Integer id);
}
