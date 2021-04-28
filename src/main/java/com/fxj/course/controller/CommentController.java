package com.fxj.course.controller;


import com.fxj.course.config.UserLoginToken;
import com.fxj.course.entity.CodeMsg;
import com.fxj.course.entity.Comment;
import com.fxj.course.entity.Result;
import com.fxj.course.entity.UserCommentVo;
import com.fxj.course.service.CommentService;
import com.fxj.course.service.UserService;
import com.fxj.course.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-03-09
 */
@RestController
@RequestMapping("/course/comment")
public class CommentController {
    @Autowired
    public CommentService commentService;
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


    @PostMapping("/getCommentList")
    public Result getCommentList(@RequestBody HashMap<String,String> maps){
        List<UserCommentVo> commentList = commentService.getCommentList(maps);
        return Result.success(commentList,200);
    }

//    新增评论
    @PostMapping("addComment")
    public Result addComment(@RequestBody HashMap<String,String> map){
        Integer userId = getUserId();
        if(userId != -1) {
            map.put("userId",String.valueOf(userId));
            Integer i = commentService.addComment(map);
            if (i != 0) {
                return Result.success("添加评论成功", 200);
            } else {
                return Result.error(new CodeMsg(500, "添加评论失败"));
            }
        }else {
            return Result.error(new CodeMsg(401, "请重新登录"));
        }
    }


}

