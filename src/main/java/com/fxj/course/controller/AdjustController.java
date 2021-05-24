package com.fxj.course.controller;


import com.fxj.course.entity.CodeMsg;
import com.fxj.course.entity.Result;
import com.fxj.course.service.AdjustService;
import com.fxj.course.service.UserService;
import com.fxj.course.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-05-16
 */
@RestController
@RequestMapping("/course/adjust")
public class AdjustController {
    @Autowired
    private AdjustService adjustService;
    @Autowired
    private UserService userService;
    public Integer getUserId(){
        String openId = TokenUtil.getTokenOpenId();
        if(openId != "") {
            Integer userId = userService.selectUserId(openId);
            return  userId;
        }else {
            return -1;
        }
    }
    @PostMapping("/update")
    public Result update(@RequestBody HashMap<String,String> maps){
        Integer userId = getUserId();
        if(userId != -1){
            Integer i = adjustService.update(userId, maps);
            if(i != 0){
                return Result.success("提交成功",200);
            }else {
                return Result.error(new CodeMsg(500,"提交失败"));
            }
        }else {
            return Result.error(new CodeMsg(401,"请重新登录"));
        }
    }
    @GetMapping("/getAdjustList")
    public Result getAdjust(){
        List list = adjustService.getAdjust();
        return Result.success(list,200);
    }
}

