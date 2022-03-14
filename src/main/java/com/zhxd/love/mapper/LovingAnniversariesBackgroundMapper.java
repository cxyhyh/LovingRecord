package com.zhxd.love.mapper;
;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhxd.love.model.entity.LovingAnniversariesBackground;

import java.util.List;

/**
 * @author xx
 */
public interface LovingAnniversariesBackgroundMapper extends BaseMapper<LovingAnniversariesBackground> {

    List<LovingAnniversariesBackground> getList();
}
