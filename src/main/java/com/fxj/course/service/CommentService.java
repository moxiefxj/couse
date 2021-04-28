package com.fxj.course.service;

import com.fxj.course.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fxj.course.entity.UserCommentVo;
import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-03-09
 */
public interface CommentService extends IService<Comment> {
    public List<UserCommentVo> getCommentList(HashMap<String,String> maps);
//    新增评论
    public Integer addComment(HashMap<String,String> map);

}
