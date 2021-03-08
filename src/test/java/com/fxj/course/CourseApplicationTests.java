package com.fxj.course;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxj.course.entity.User;
import com.fxj.course.mapper.UserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
class CourseApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
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

        String encodekey = DigestUtils.md5Hex("测试MD5");
        String encodekey01 = DigestUtils.md5Hex("测试MD5");
        System.out.println(encodekey.equals(encodekey01));
    }
    @Test
    void testRedis() throws JsonProcessingException {
//        从redis缓存中获得指定的数据
        String userListData = (String) redisTemplate.boundValueOps("userMapper.selectList(null)").get();
//如果redis中没有数据的话
        if(null==userListData){
//查询数据库获得数据
            List<User> all = userMapper.selectList(null);
//转换成json格式字符串
            ObjectMapper om = new ObjectMapper();
            userListData = om.writeValueAsString(all);
//将数据存储到redis中，下次在查询直接从redis中获得数据，不用在查询数据库
            redisTemplate.boundValueOps("userMapper.selectList(null)").set(userListData);
            System.out.println("===============从数据库获得数据===============");
        }else{
            System.out.println("===============从redis缓存中获得数据===============");
        }
        System.out.println(userListData);
    }

}
