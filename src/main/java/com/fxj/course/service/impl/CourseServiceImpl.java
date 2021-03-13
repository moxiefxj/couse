package com.fxj.course.service.impl;

import com.fxj.course.entity.ClassfiyCourseVo;
import com.fxj.course.entity.Course;
import com.fxj.course.mapper.CourseMapper;
import com.fxj.course.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
