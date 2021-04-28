package com.fxj.course.service.impl;

import com.fxj.course.entity.Comment;
import com.fxj.course.entity.UserCommentVo;
import com.fxj.course.mapper.CommentMapper;
import com.fxj.course.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-03-09
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    public CommentMapper commentMapper;
    @Override
    public List<UserCommentVo> getCommentList(HashMap<String, String> maps) {
        List<UserCommentVo> list = commentMapper.getCommentList(maps.get("course_id"));
        /**
         * 根据userid查找出用户信息
         */
        System.out.println(list);
        return list;
    }

    @Override
    public Integer addComment(HashMap<String, String> map) {
        Comment comment = new Comment();
        comment.setUserId(Integer.parseInt(map.get("userId")));
        comment.setCourseId(Integer.parseInt(map.get("courseId")));
        comment.setScore(Integer.parseInt(map.get("rate")));
        comment.setContent(map.get("comment"));
        comment.setZan(0);
        Integer i = commentMapper.insert(comment);
        return i;
    }


}
