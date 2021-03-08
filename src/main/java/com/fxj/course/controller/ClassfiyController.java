package com.fxj.course.controller;

import com.fxj.course.entity.Classfiy;
import com.fxj.course.entity.Result;
import com.fxj.course.service.ClassfiyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-02-25
 */
@RestController
public class ClassfiyController {
    @Autowired
    public ClassfiyService classfiyService;

    @GetMapping("/getClassfiy")
    public Result selectAll(){
        List<Classfiy> classfiys = classfiyService.selectAll();
        System.out.println(classfiys);
        return Result.success(classfiys,200);
    }
}
