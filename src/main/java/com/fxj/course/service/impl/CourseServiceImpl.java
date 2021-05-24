package com.fxj.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fxj.course.entity.ClassfiyCourseVo;
import com.fxj.course.entity.Course;
import com.fxj.course.mapper.CourseMapper;
import com.fxj.course.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
        queryWrapper.select("id,classfiy_id,course_img,course_name,teacher,lecturer_resume,promotion_url,brief")
                .like("course_name",keyValue);
        List<Course> courses = courseMapper.selectList(queryWrapper);
        return courses;
    }

    @Override
    public Integer updateCourse(HashMap<String, String> map) {
        Course course = new Course();
        course.setCourseName(map.get("course_name"));
        course.setCourseImg(map.get("course_img"));
        course.setBrief(map.get("brief"));
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

    @Override
    public List selectCourseByClassfiyId(List id) {
        HashMap map = new HashMap();
        for (int i = 0; i < id.size(); i++) {
            map.put("classfiy_id",id.get(i));
        }
        List list = courseMapper.selectByMap(map);
        return list;
    }

    @Override
    public List<Course> getCourseCollectList(List list) {
        ArrayList list1 = new ArrayList();
        if(list.size() == 0){
            return list1;
        }
        HashMap map = new HashMap();
        System.out.println(list);
        List list2 = courseMapper.selectBatchIds(list);
        System.out.println("list2"+list2.size());
//        for (int i = 0; i < list.size(); i++) {
//            map.put("id",list.get(i));
//            list1.add(courseMapper.selectByMap(map));
//        }
        return list2;
    }

    @Override
    public Integer delCourse(String id) {
        Integer i = courseMapper.deleteById(id);
        return i;
    }

    @Override
    public Integer modifyCourse(HashMap<String,String> map) {
        Course course = new Course();
        course.setId(Integer.parseInt(map.get("id")));
        course.setCourseName(map.get("course_name"));
        course.setBrief(map.get("brief"));
        course.setTeacher(map.get("teacher"));
        course.setLecturerResume(map.get("lecturerResume"));
        Integer i = courseMapper.updateById(course);
        return i;
    }

}
