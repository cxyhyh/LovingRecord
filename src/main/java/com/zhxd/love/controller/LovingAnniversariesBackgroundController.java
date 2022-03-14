package com.zhxd.love.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhxd.love.constant.Constant;
import com.zhxd.love.model.entity.LovingAlbum;
import com.zhxd.love.model.entity.LovingAnniversariesBackground;
import com.zhxd.love.model.entity.LovingImg;
import com.zhxd.love.service.LovingAnniversariesBackgroundService;
import com.zhxd.love.util.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author xx
 */
@RestController
@RequestMapping("/lovingAnniversariesBackground")
public class LovingAnniversariesBackgroundController {

    @Autowired
    private LovingAnniversariesBackgroundService lovingAnniversariesBackgroundService;

    @ApiOperation("上传图片")
    @PostMapping("/uploadImg")
    public Result uploadImg(MultipartFile[] file) throws IOException {

        String fileDir =  Constant.fileDir;
        System.out.println("------->>" + fileDir);
        File dir = new File(fileDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        boolean flag = false;
        for (int i = 0;i<file.length;i++){
            Long startTs = System.currentTimeMillis(); // 当前时间戳
            String fileName = startTs+"_" + file[i].getOriginalFilename();
            File upload_file = new File(fileDir + File.separator + fileName);
            file[i].transferTo(upload_file);
            LovingAnniversariesBackground lovingAnniversariesBackground = new LovingAnniversariesBackground();
            lovingAnniversariesBackground.setUrl(fileName);
            lovingAnniversariesBackground.setCreateDate(new Date());
            lovingAnniversariesBackground.setUpdateDate(new Date());
            flag = lovingAnniversariesBackgroundService.save(lovingAnniversariesBackground);

        }
        if (flag){
            return Result.success(200,"图片上传成功");
        }else
            return Result.fail(400,"图片上传失败");
    }

    /**
     * 通过ID查询信息
     *
     * @param
     * @return
     */
    @GetMapping("/list")
    public Result getList() {
        return Result.success(lovingAnniversariesBackgroundService.getList());
    }

    /**
     * 通过ID查询信息
     *
     * @param id ID
     * @return
     */
    @GetMapping("/{id}")
    public LovingAnniversariesBackground get(@PathVariable Integer id) {
        return lovingAnniversariesBackgroundService.getById(id);
    }

    /**
     * 添加
     *
     * @param lovingAnniversariesBackground
     * @return success、false
     */
    @PostMapping
    public Result add(@RequestBody LovingAnniversariesBackground lovingAnniversariesBackground) {
        return Result.success(lovingAnniversariesBackgroundService.save(lovingAnniversariesBackground));
    }

    /**
     * 删除
     *
     * @param id   ID
     * @return R
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(lovingAnniversariesBackgroundService.removeById(id));
    }

    /**
     * 修改
     *
     * @param lovingAnniversariesBackground
     * @return success/false
     */
    @PutMapping
    public Result editDict(@RequestBody LovingAnniversariesBackground lovingAnniversariesBackground) {
        return Result.success(lovingAnniversariesBackgroundService.updateById(lovingAnniversariesBackground));
    }
}
