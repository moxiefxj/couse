package com.fxj.course.controller;


import com.fxj.course.entity.CodeMsg;
import com.fxj.course.entity.Menu;
import com.fxj.course.entity.Result;
import com.fxj.course.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 目录表 前端控制器
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-03-09
 */
@RestController
@RequestMapping("/course/menu")
public class MenuController {

    @Autowired
    public MenuService menuService;
    public CodeMsg codeMsg;

    @PostMapping("list")
    public Result selectList(@RequestBody HashMap<String,String> map){
        String id = map.get("id");
        List<Menu> menus = menuService.selectList(id);
        return Result.success(menus,200);
    }
    @PostMapping("addMenu")
    public Result addMenu(@RequestBody HashMap<String,String> map){
        Integer i = menuService.addMenu(map);
        if(i != 0){
            return Result.success("插入成功",200);
        }else {
            return Result.error(new CodeMsg(500,"插入失败"));
        }
    }
    @PostMapping("chapterList")
    public Result getChapterList(@RequestBody HashMap<String,String> map){
        List list = menuService.selectChapterList(map);
        return  Result.success(list,200);
    }
    @PostMapping("delMenu")
    public Result delMenu(@RequestBody HashMap<String,String> map){
        Integer id = menuService.delMenu(map.get("id"));
        if(id != 0){
            return Result.success("删除成功",200);
        }else{
            return  Result.error(new CodeMsg(500,"删除失败"));
        }
    }
    @PostMapping("modifyMenu")
    public Result modifyMenu(@RequestBody HashMap<String,String> map){
        Integer i = menuService.modifyMenu(map);
        if(i != 0){
            return Result.success("更新成功",200);
        }else{
            return  Result.error(new CodeMsg(500,"更新失败"));
        }
    }

}

