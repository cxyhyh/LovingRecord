package com.zhxd.love.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhxd.love.model.entity.LovingAlbum;
import com.zhxd.love.model.entity.LovingImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.mapper
 * @Class LovingAlbumMapper
 * @Date 2022/2/24 10:24
 */
@Repository
public interface LovingAlbumMapper extends BaseMapper<LovingAlbum> {

    LovingAlbum getByName(String albumName);

    List<LovingAlbum> getByUser(Integer userId);

    LovingAlbum getPictureAndVideoNUm(@Param("Name") String albumName);

    Integer getIdByName(String albumName);

    String getNameById(Integer id);
}
