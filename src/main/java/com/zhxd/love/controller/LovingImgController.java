package com.zhxd.love.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zhxd.love.constant.Constant;
import com.zhxd.love.model.entity.LovingAlbum;
import com.zhxd.love.model.entity.LovingAnniversariesBackground;
import com.zhxd.love.model.entity.LovingImg;
import com.zhxd.love.service.LovingAlbumService;
import com.zhxd.love.service.LovingImgService;
import com.zhxd.love.util.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.controller
 * @Class LovingImgController
 * @Date 2022/2/24 10:24
 */
@RestController
@RequestMapping("/lovingImg")
public class LovingImgController {

    @Autowired
    private LovingImgService lovingImgService;
    @Autowired
    private LovingAlbumService lovingAlbumService;

    /**
     * 查询该用户下的相册下的所有照片
     *
     * @param
     * @return success、false
     */
    @GetMapping("/getAlbumDetail")
    public Result getAlbumDetail(String albumId) {
        Integer id = Integer.parseInt(albumId);
        return Result.success(lovingImgService.getAlbumDetailById(id));
    }


    @ApiOperation("上传图片")
    @PostMapping("/uploadImg")
    public Result uploadImg(String albumName, MultipartFile[] file) throws IOException {

        Integer id = lovingAlbumService.getIdByName(albumName);
        String fileDir = Constant.fileDir;
        System.out.println("------->>" + fileDir);
        File dir = new File(fileDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        boolean flag = false;
        int numb = 0;
        Long startTs = System.currentTimeMillis(); // 当前时间戳
        for (int i = 0;i<file.length;i++){
            String fileName = startTs+"_" + file[i].getOriginalFilename();
            File upload_file = new File(fileDir + File.separator + fileName);
            file[i].transferTo(upload_file);
            LovingImg lovingImg = new LovingImg();
            lovingImg.setImgUrl(fileName);
            lovingImg.setAlbumId(id);
            lovingImg.setCreateDate(new Date());
            lovingImg.setUpdateDate(new Date());
            flag = lovingImgService.save(lovingImg);
            numb = i+1;
        }
        LovingAlbum lovingAlbum = lovingAlbumService.getByName(albumName);
        UpdateWrapper<LovingAlbum> updateWrapper = new UpdateWrapper<>();
        Integer num = numb +Integer.parseInt(lovingAlbum.getPictureNum());
        updateWrapper.set("img_first",startTs+"_" + file[0].getOriginalFilename())
                .set("picture_num",num).eq("id",id);
        lovingAlbumService.update(updateWrapper);
        if (flag){
            return Result.success(200,"图片上传成功");
        }else
        return Result.fail(400,"图片上传失败");
    }


    /**
     * 通过ID查询信息
     *
     * @param id ID
     * @return
     */
    @GetMapping("/{id}")
    public LovingImg get(@PathVariable Integer id) {
        return lovingImgService.getById(id);
    }

    /**
     * 添加
     *
     * @param lovingImg
     * @return success、false
     */
    @PostMapping
    public Result add(@RequestBody LovingImg lovingImg) {
        return Result.success(lovingImgService.save(lovingImg));
    }

    /**
     * 删除
     *
     * @param id   ID
     * @return R
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(lovingImgService.removeById(id));
    }

    /**
     * 修改
     *
     * @param lovingImg
     * @return success/false
     */
    @PutMapping
    public Result editDict(@RequestBody LovingImg lovingImg) {
        return Result.success(lovingImgService.updateById(lovingImg));
    }
}
