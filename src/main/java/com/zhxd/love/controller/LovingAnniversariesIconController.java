package com.zhxd.love.controller;
import com.zhxd.love.model.entity.LovingAnniversariesIcon;
import com.zhxd.love.service.LovingAnniversariesIconService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhxd.love.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author hyh
 */
@RestController
@RequestMapping("/lovingAnniversariesIcon")
public class LovingAnniversariesIconController {

    @Autowired
    private LovingAnniversariesIconService lovingAnniversariesIconService;

    /**
     * 通过ID查询信息
     *
     * @param
     * @return
     */
    @GetMapping("/list")
    public Result getList() {
        return Result.success(lovingAnniversariesIconService.getList());
    }

    /**
     * 通过ID查询信息
     *
     * @param id ID
     * @return
     */
    @GetMapping("/{id}")
    public LovingAnniversariesIcon get(@PathVariable Integer id) {
        return lovingAnniversariesIconService.getById(id);
    }

    /**
     * 添加
     *
     * @param lovingAnniversariesIcon
     * @return success、false
     */
    @PostMapping
    public Result add(@RequestBody LovingAnniversariesIcon lovingAnniversariesIcon) {
        return Result.success(lovingAnniversariesIconService.save(lovingAnniversariesIcon));
    }

    /**
     * 删除
     *
     * @param id   ID
     * @return R
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(lovingAnniversariesIconService.removeById(id));
    }

    /**
     * 修改
     *
     * @param lovingAnniversariesIcon
     * @return success/false
     */
    @PutMapping
    public Result editDict(@RequestBody LovingAnniversariesIcon lovingAnniversariesIcon) {
        return Result.success(lovingAnniversariesIconService.updateById(lovingAnniversariesIcon));
    }
}
