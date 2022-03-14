package com.zhxd.love.controller;

import com.zhxd.love.model.entity.LovingAnniversaries;
import com.zhxd.love.service.LovingAnniversariesService;
import com.zhxd.love.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * @author hyh
 */
@RestController
@RequestMapping("/lovingAnniversaries")
public class LovingAnniversariesController {

    @Autowired
    private LovingAnniversariesService lovingAnniversariesService;


    /**
     * 保存纪念日
     *
     * @param  lovingAnniversaries
     * @return
     */
    @PostMapping("/saveAnniversaries")
    public Result saveAnniversaries(@Valid @RequestBody LovingAnniversaries lovingAnniversaries) {
        boolean flag = false;
        List<LovingAnniversaries> list =  lovingAnniversariesService.getByName(lovingAnniversaries.getName());
        if (list.size()>0){
            return Result.fail(400,"纪念日名称已存在！");
        }else {
            flag = lovingAnniversariesService.saveAnniversaries(lovingAnniversaries);
            if (flag) {return Result.success(200,"保存成功");}
                else return Result.fail(400,"保存失败");}

    }

    /**
     * 通过ID查询信息
     *
     * @param id ID
     * @return
     */
    @GetMapping("/{id}")
    public LovingAnniversaries get(@PathVariable Integer id) {
        return lovingAnniversariesService.getById(id);
    }

    /**
     * 分页查询
     *
     * @param params 分页对象
     * @return 分页对象
     */
//    @GetMapping("/page")
//    public IPage dictPage(@RequestParam Map<String, Object> params) {
//        return lovingAnniversariesService.page(new Query<>(params), new QueryWrapper<>());
//    }

    /**
     * 添加
     *
     * @param lovingAnniversaries
     * @return success、false
     */
    @PostMapping
    public Result add(@RequestBody LovingAnniversaries lovingAnniversaries) {
        return Result.success(lovingAnniversariesService.save(lovingAnniversaries));
    }

    /**
     * 删除
     *
     * @param id   ID
     * @return R
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(lovingAnniversariesService.removeById(id));
    }

    /**
     * 修改
     *
     * @param lovingAnniversaries
     * @return success/false
     */
    @PutMapping
    public Result editDict(@RequestBody LovingAnniversaries lovingAnniversaries) {
        return Result.success(lovingAnniversariesService.updateById(lovingAnniversaries));
    }
}
