package com.fxj.course.mapper;

import com.fxj.course.entity.ClassfiyCourseVo;
import com.fxj.course.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fxj.course.entity.UserCommentVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-03-09
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("SELECT u.id,u.avatar_url,u.name,u.gender,c.content,c.score,c.create_time" +
            " from user u,comment c " +
            "WHERE c.user_id = u.id AND c.course_id = #{courseId}")
    List<UserCommentVo> getCommentList(String courseId);
}
