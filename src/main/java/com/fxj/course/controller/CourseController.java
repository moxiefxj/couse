package com.fxj.course.controller;


import com.fxj.course.entity.ClassfiyCourseVo;
import com.fxj.course.entity.CodeMsg;
import com.fxj.course.entity.Course;
import com.fxj.course.entity.Result;
import com.fxj.course.service.CourseService;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/course/course")
public class CourseController {

    @Autowired
    public CourseService courseService;
    public CodeMsg codeMsg;

    @PostMapping("detail")
    public Result selectDetail(@RequestBody HashMap<String,String> map){
        String courseId = map.get("id");
        Course course = courseService.selectCourse(courseId);
        System.out.println("controller"+course);
        if(course != null){
            return Result.success(course,200);
        }else {
            System.out.println("jj");
            return  Result.error(new CodeMsg(400,"未找到相关课程"));
        }

    }

    /**
     * 根据classfiy查询课程
     * @param map
     * @return
     */
    @PostMapping("selectClassfiyCourseList")
    public Result selectClassfiyCourseList(@RequestBody HashMap<String,String> map){
        String classfiy = map.get("classfiy");
        List<ClassfiyCourseVo> classfiyCourseVos = courseService.selectClassfiyCourseList(classfiy);
        return Result.success(classfiyCourseVos,200);
    }

    /**
     * 根据第一层分类
     * @param map
     * @return
     */
    @PostMapping("selectLevel1CourseList")
    public Result selectLevel1CourseList(@RequestBody HashMap<String,String> map){
        String level1 = map.get("level1");
        List<ClassfiyCourseVo> level1CourseVos = courseService.selectLevel1CourseList(level1);
        return Result.success(level1CourseVos,200);
    }

    /**
     * 根据第二层分类
     * @param map
     * @return
     */

    @PostMapping("selectLevel2CourseList")
    public Result selectLevel2CourseList(@RequestBody HashMap<String,String> map){
        String level2 = map.get("level2");
        List<ClassfiyCourseVo> level2CourseVos = courseService.selectLevel2CourseList(level2);
        return Result.success(level2CourseVos,200);
    }

    /**
     * 根据关键字查找
     * @param map
     * @return
     */
    @PostMapping("searchKey")
    public Result selectKeyCourse(@RequestBody HashMap<String,String> map){
        List<Course> courses = courseService.selectKeyCourse(map.get("keyValue"));
        System.out.println(map.get("keyValue"));
        return Result.success("成功",200);
    }

    /**
     * 新增课程
     * @param map
     * @return
     */
    @PostMapping("updateCourse")
    public Result updateCourse(@RequestBody HashMap<String,String> map){
        Integer i = courseService.updateCourse(map);
        if(i == 1){
            return Result.success("成功",200);
        }else {
            return Result.error(new CodeMsg(500,"更新失败"));
        }
    }
    @GetMapping("getCourseList")
    public Result getCourseList(){
        List<Course> courseList = courseService.getCourseList();
        return Result.success(courseList,200);
    }

}

