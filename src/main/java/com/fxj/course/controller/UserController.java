package com.fxj.course.controller;


import com.fxj.course.entity.Result;
import com.fxj.course.entity.User;
import com.fxj.course.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-01-04
 */
@RestController
@RequestMapping("/course/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/hello")
    public Result hello(String tel) {
        HashMap<String, Object> map = new HashMap<>();
//        自定义查询
        map.put("tel",tel);

        List<User> userList = userMapper.selectByMap(map);
        System.out.println(userList);
        return Result.success(userList,200);
    }

    @GetMapping("/helloworld")
    public String helloworld() {
        return "hello world";
    }
}

