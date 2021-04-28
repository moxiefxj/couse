package com.fxj.course.service.impl;

import com.fxj.course.entity.User;
import com.fxj.course.mapper.UserMapper;
import com.fxj.course.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2021-01-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    public UserMapper userMapper;
    @Override
    public User checkUser(String openId) {
        HashMap map = new HashMap();
        map.put("open_id",openId);
        List<User> list = userMapper.selectByMap(map);
        if(list.size() > 0){
            return list.get(0);
        }else {
            return null;
        }

    }

    @Override
    public Boolean setUserInfo(HashMap map) {
        User user = new User();
        HashMap map1 = (HashMap) map.get("userInfo");
        user.setOpenId(String.valueOf(map.get("openId")));
        user.setName(String.valueOf(map1.get("nickName")));
        user.setAvatarUrl(String.valueOf(map1.get("avatarUrl")));
        user.setCity(String.valueOf(map1.get("city")));
        user.setProvince(String.valueOf(map1.get("province")));
        user.setCountry(String.valueOf(map1.get("country")));
        user.setGender(String.valueOf(map1.get("gender")));
//        role 1为学生，2为管理员
        user.setRole("1");
        int i = userMapper.insert(user);
        if(i != 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Integer selectUserId(String openId) {
        HashMap map = new HashMap();
        map.put("open_id",openId);
        List<User> list = userMapper.selectByMap(map);
        Integer id;
        if(list.size() != 0){
            User user =  list.get(0);
            id = Math.toIntExact(user.getId());
            return id;
        }else {
            return -1;
        }
    }
}
