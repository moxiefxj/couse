package com.fxj.course.controller;


import com.fxj.course.entity.*;
import com.fxj.course.service.ClassfiyService;
import com.fxj.course.service.CollectService;
import com.fxj.course.service.CourseService;
import com.fxj.course.service.UserService;
import com.fxj.course.utils.TokenUtil;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
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
    @Autowired
    public ClassfiyService classfiyService;
    @Autowired
    public UserService userService;
    @Autowired
    public CollectService collectService;
    public CodeMsg codeMsg;

    public Integer getUserId(){
        String openId = TokenUtil.getTokenOpenId();
        if(openId != "") {
            Integer userId = userService.selectUserId(openId);
            return  userId;
        }else {
            return -1;
        }
    }

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
        return Result.success(courses,200);
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
    @PostMapping("modifyCourse")
    public Result modifyCourse(@RequestBody HashMap<String,String> map){
        Integer i = courseService.modifyCourse(map);
        if(i == 1){
            return Result.success("成功",200);
        }else {
            return Result.error(new CodeMsg(500,"更新失败"));
        }
    }

    /**
     * 管理台获取所有课程列表
     * @return
     */
    @GetMapping("getCourseList")
    public Result getCourseList(){
        List<Course> courseList = courseService.getCourseList();
        return Result.success(courseList,200);
    }

    @PostMapping("getCourseListById")
    public Result getCourseListById(@RequestBody HashMap<String,String> maps){
        List ids = classfiyService.getClassfiyIds(maps.get("id"));
        ids.add(maps.get("id"));
        List list = courseService.selectCourseByClassfiyId(ids);
        return Result.success(list,200);
    }

    @GetMapping("getCourseCollectList")
    public Result getCourseCollectList(){
        Integer userId = getUserId();
        if(userId != -1){
            List list1 = collectService.getCourseId(userId);
            List<Course> list = courseService.getCourseCollectList(list1);
            return Result.success(list,200);
        }else {
            return Result.error(new CodeMsg(401,"请重新登录"));
        }
    }

    @PostMapping("delCourse")
    public Result delMenu(@RequestBody HashMap<String,String> map){
        Integer id = courseService.delCourse(map.get("id"));
        if(id != 0){
            return Result.success("删除成功",200);
        }else{
            return  Result.error(new CodeMsg(500,"删除失败"));
        }
    }
}

