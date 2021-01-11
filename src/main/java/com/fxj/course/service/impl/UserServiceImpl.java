package com.fxj.course.service.impl;

import com.fxj.course.entity.User;
import com.fxj.course.mapper.UserMapper;
import com.fxj.course.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
