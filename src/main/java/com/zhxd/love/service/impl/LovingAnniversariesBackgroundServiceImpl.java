package com.zhxd.love.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zhxd.love.constant.Constant;
import com.zhxd.love.mapper.LovingAnniversariesBackgroundMapper;
import com.zhxd.love.model.entity.LovingAnniversariesBackground;
import com.zhxd.love.service.LovingAnniversariesBackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xx
 */
@Service
public class LovingAnniversariesBackgroundServiceImpl extends ServiceImpl<LovingAnniversariesBackgroundMapper, LovingAnniversariesBackground> implements LovingAnniversariesBackgroundService {
    @Autowired
    private LovingAnniversariesBackgroundMapper lovingAnniversariesBackgroundMapper;

    @Override
    public List<LovingAnniversariesBackground> getList() {
        String filePath =  Constant.fileDir;
        List<LovingAnniversariesBackground> backgroundList = this.baseMapper.getList();
        for (LovingAnniversariesBackground b:backgroundList) {
            if (!b.getUrl().contains("http")){
                String path = filePath +  File.separator + b.getUrl();
                String url = getImageStr(path);
                b.setUrl(url);
            }
        }
        return backgroundList;

    }

    /**
     * @Description: 根据图片地址转换为base64编码字符串
     * @Author:
     * @CreateTime:
     * @return
     */
    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return "data:image/png;base64,"+ encoder.encode(data);
    }

}