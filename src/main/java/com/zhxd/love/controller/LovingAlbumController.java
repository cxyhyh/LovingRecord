package com.zhxd.love.controller;

import com.zhxd.love.constant.Constant;
import com.zhxd.love.model.entity.LovingAlbum;
import com.zhxd.love.service.LovingAlbumService;
import com.zhxd.love.service.LovingImgService;
import com.zhxd.love.util.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.controller
 * @Class LovingAlbumController
 * @Date 2022/2/24 10:24
 */
@RestController
@RequestMapping("/lovingAlbum")
public class LovingAlbumController {

    @Autowired
    private LovingAlbumService lovingAlbumService;
    @Autowired
    private LovingImgService lovingImgService;

    /**
     * 通过相册名称查询id
     * @param
     * @return
     */
    @GetMapping("/getIdByName")
    public Result getIdByName(String albumName) {
        return Result.success(lovingAlbumService.getIdByName(albumName));
    }

    /**
     * 通过相册名称查询id
     *
     * @param
     * @return
     */
    @GetMapping("/getNameById")
    public Result getNameById(Integer id) {
        return Result.success(lovingAlbumService.getNameById(id));
    }

    /**
     * 查询相册的照片和视频数量
     *
     * @param
     * @return
     */
    @GetMapping("/getPictureAndVideoNum")
    public Result getPictureAndVideoNUm(String albumName) {
        return Result.success(lovingAlbumService.getPictureAndVideoNUm(albumName));
    }

    /**
     * 第一次新建相册时查询该用户下的所有相册
     *
     * @param
     * @return
     */
    @GetMapping("/getAlbum")
    public Result getAlbum(String userId) {
        Integer id = Integer.parseInt(userId);
       return Result.success(lovingAlbumService.getByUser(id));
    }

    /**
     * 新建相册
     *
     * @param lovingAlbum
     * @return success、false
     */
    @PostMapping("/add")
    public Result add(LovingAlbum lovingAlbum) {

        boolean flag = false;
        Date date = new Date();
        lovingAlbum.setCreateDate(date);
        lovingAlbum.setUpdateDate(date);
        lovingAlbum.setVideoNum("0");
        lovingAlbum.setPictureNum("0");
        lovingAlbum.setImgFirst(Constant.PHOTO_MAN);
        LovingAlbum lovingAlbum1 = lovingAlbumService.getByName(lovingAlbum.getAlbumName());
        if (lovingAlbum1 != null){
            return Result.fail(400,"相册已存在!请换一个相册名称");
        }
        else {
           flag = lovingAlbumService.save(lovingAlbum);
           if (flag){
               return Result.success(lovingAlbum);
           }
        }

        return Result.success(lovingAlbum);
    }

    /**
     * 通过ID查询信息
     *
     * @param id ID
     * @return
     */
    @GetMapping("/{id}")
    public LovingAlbum get(@PathVariable Integer id) {
        return lovingAlbumService.getById(id);
    }




    /**
     * 删除
     *
     * @param id ID
     * @return R
     */
    @GetMapping("/delete")
    public Result delete(Integer id) {
        lovingAlbumService.removeById(id);
        lovingImgService.deleteByAlbumId(id);
        return Result.success("删除成功");
    }

    /**
     * 修改
     *
     * @param lovingAlbum
     * @return success/false
     */
    @PostMapping("/edit")
    public Result editDict(LovingAlbum lovingAlbum) {
        lovingAlbumService.updateById(lovingAlbum);
        return Result.success("修改成功");
    }
}
