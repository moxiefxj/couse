package com.fxj.course.service;

import com.fxj.course.entity.ClassfiyCourseVo;
import com.fxj.course.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface CourseService extends IService<Course> {
//    根据课程id查询课程信息
   public Course selectCourse(String id);

   //    根据classfiy查找相关课程
   public List<ClassfiyCourseVo> selectClassfiyCourseList(String classfiy);

//   根据level1查询相关课程
   public List<ClassfiyCourseVo> selectLevel1CourseList(String level1);
    //   根据level2查询相关课程
    public List<ClassfiyCourseVo> selectLevel2CourseList(String level2);

    /**
     * 关键字查找课程
     * @param keyValue
     * @return
     */
    public List<Course> selectKeyCourse(String keyValue);

//    新增课程
    public Integer updateCourse(HashMap<String,String> map);
//    查询课程列表
    public List<Course> getCourseList();
}