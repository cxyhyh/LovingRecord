package com.zhxd.love.mapper;

import com.zhxd.love.model.entity.LovingImg;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.mapper
 * @Class LovingImgMapper
 * @Date 2022/2/24 10:24
 */
@Repository
public interface LovingImgMapper extends BaseMapper<LovingImg> {

    List<LovingImg> getAlbumDetailById(Integer albumId);

    void deleteByAlbumId(Integer albumId);
}
