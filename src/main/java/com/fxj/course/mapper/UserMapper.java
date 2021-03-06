package com.fxj.course.mapper;

import com.fxj.course.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-01-04
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
