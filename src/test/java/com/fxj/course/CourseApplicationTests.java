package com.fxj.course;

import com.fxj.course.entity.User;
import com.fxj.course.mapper.UserMapper;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
//        新增数据
//        User user = new User();
//        user.setName("冯筱静01");
//        user.setAge(10);
//        user.setBrief("爱学习的我01");
//        user.setPassword("111111");
//        user.setTel("18780227212");
//        user.setRole("user");
//        System.out.println(user);
//        int i = userMapper.insert(user);
//        System.out.println(i);
    }
    @Test
    void testUpadte() {
//        User user = userMapper.selectById(2L);
//        user.setAge(11);
//        userMapper.updateById(user);
    }

}
