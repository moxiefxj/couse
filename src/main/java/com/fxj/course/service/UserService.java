package com.fxj.course.service;

import com.fxj.course.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-01-04
 */
public interface UserService extends IService<User> {
//    判断是否注册
    public User checkUser(String openId);

//    添加用户信息
    public Boolean setUserInfo(HashMap map);

//    根据openid找出userid
    public Integer selectUserId(String openId);
}
