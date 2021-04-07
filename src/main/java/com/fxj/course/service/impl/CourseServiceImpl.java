package com.fxj.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fxj.course.entity.ClassfiyCourseVo;
import com.fxj.course.entity.Course;
import com.fxj.course.mapper.CourseMapper;
import com.fxj.course.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import com.sun.org.apache.bcel.internal.generic.DCONST;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    public CourseMapper courseMapper;

    @Override
    public Course selectCourse(String id) {
        Integer courseid = Integer.parseInt(id);
        Course course = courseMapper.selectById(courseid);
        return course;
    }

    @Override
    public List<ClassfiyCourseVo> selectClassfiyCourseList(String classfiy) {
        List<ClassfiyCourseVo> courseClassfiyList = courseMapper.getCourseClassfiyList(classfiy);
        return courseClassfiyList;
    }

    @Override
    public List<ClassfiyCourseVo> selectLevel1CourseList(String level1) {
        List<ClassfiyCourseVo> courseLevel1List = courseMapper.getCourseLevel1List(level1);
        return courseLevel1List;
    }

    @Override
    public List<ClassfiyCourseVo> selectLevel2CourseList(String level2) {
        List<ClassfiyCourseVo> courseLevel2List = courseMapper.getCourseLevel2List(level2);
        return courseLevel2List;
    }

    @Override
    public List<Course> selectKeyCourse(String keyValue) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id,classfiy_id,course_img,course_name,teacher")
                .like("course_name",keyValue);
        List<Course> courses = courseMapper.selectList(queryWrapper);
        return null;
    }

    @Override
    public Integer updateCourse(HashMap<String, String> map) {
        Course course = new Course();
        course.setCourseName(map.get("course_name"));
        course.setCourseImg(map.get("course_img"));
        course.setTeacher(map.get("teacher"));
        course.setPromotionUrl(map.get("url"));
        course.setLecturerResume(map.get("lecturerResume"));
        course.setClassfiyId(Integer.parseInt(map.get("classfiy")));
        Integer i = courseMapper.insert(course);
        return i;
    }

//    @Override
    public List<Course> getCourseList() {
        List<Course> courses = courseMapper.selectList(null);
        return courses;
    }
}
