package com.fxj.course.service;

import com.fxj.course.entity.ClassfiyCourseVo;
import com.fxj.course.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-03-09
 */
public interface CourseService extends IService<Course> {
//    根据课程id查询课程信息
   public Course selectCourse(String id);

   //    根据classfiy查找相关课程
   public List<ClassfiyCourseVo> selectClassfiyCourseList(String classfiy);

//   根据level1查询相关课程
   public List<ClassfiyCourseVo> selectLevel1CourseList(String level1);
    //   根据level2查询相关课程
    public List<ClassfiyCourseVo> selectLevel2CourseList(String level2);
}
