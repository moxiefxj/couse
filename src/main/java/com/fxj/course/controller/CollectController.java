package com.fxj.course.controller;


import com.fxj.course.config.UserLoginToken;
import com.fxj.course.entity.CodeMsg;
import com.fxj.course.entity.Result;
import com.fxj.course.service.CollectService;
import com.fxj.course.service.UserService;
import com.fxj.course.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 * 收藏表 前端控制器
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-04-10
 */
@RestController
@RequestMapping("/course/collect")
public class CollectController {

    @Autowired
    public CollectService collectService;
    @Autowired
    public UserService userService;

    public Integer getUserId(){
        String openId = TokenUtil.getTokenOpenId();
        if(openId != "") {
            Integer userId = userService.selectUserId(openId);
            return  userId;
        }else {
            return -1;
        }
    }

    //    执行收藏操作
    @UserLoginToken
    @PostMapping("/updateCollect")
    public Result updateCollect(@RequestBody HashMap<String,String> maps){
        Integer userId = getUserId();
        if(userId != -1){
            Integer i = collectService.updateCollect(userId, Integer.parseInt(maps.get("id")));
            if(i != 0){
                return Result.success("收藏成功",200);
            }else {
                return Result.error(new CodeMsg(500,"收藏失败"));
            }
        }else {
            return Result.error(new CodeMsg(401,"请重新登录"));
        }
    }

    @PostMapping("/checkCollect")
    public Result checkCollect(@RequestBody HashMap<String,String> map){
        Integer userId = getUserId();
        if(userId != -1){
            Boolean i = collectService.checkCollect(userId, Integer.parseInt(map.get("id")));
            return Result.success(i,200);
        }else {
            return Result.error(new CodeMsg(401,"请重新登录"));
        }
    }
//
    @PostMapping("/delCollect")
    public Result delCollect(@RequestBody HashMap<String,String> maps){
        Integer userId = getUserId();
        if(userId != -1){
            Integer i = collectService.delCollect(userId, Integer.parseInt(maps.get("id")));
        if(i != 0){
            return Result.success("取消收藏成功",200);
        }else {
            return Result.error(new CodeMsg(500,"取消收藏失败"));
        }
        }else {
            return Result.error(new CodeMsg(401,"请重新登录"));
        }
    }

}

