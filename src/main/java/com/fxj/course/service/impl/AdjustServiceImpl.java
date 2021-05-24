package com.fxj.course.service.impl;

import com.fxj.course.entity.Adjust;
import com.fxj.course.entity.AdjustUserVo;
import com.fxj.course.entity.User;
import com.fxj.course.mapper.AdjustMapper;
import com.fxj.course.mapper.UserMapper;
import com.fxj.course.service.AdjustService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-05-16
 */
@Service
public class AdjustServiceImpl extends ServiceImpl<AdjustMapper, Adjust> implements AdjustService {

    @Autowired
    public AdjustMapper adjustMapper;
    @Autowired
    public UserMapper userMapper;
    @Override
    public Integer update(Integer userId, HashMap<String, String> maps) {
        Adjust adjust = new Adjust();
        adjust.setUserId(userId);
        adjust.setAdjust(maps.get("adjust"));
        Integer i = adjustMapper.insert(adjust);
        return i;
    }

    @Override
    public List getAdjust() {
        List<AdjustUserVo> adjustUserVos =new ArrayList<>();
        List<Adjust> adjusts = adjustMapper.selectList(null);
        System.out.println(adjusts);
        for (int i = 0; i < adjusts.size(); i++) {
            Integer userId = adjusts.get(i).getUserId();
            User user = userMapper.selectById(userId);
            AdjustUserVo adjustUserVo = new AdjustUserVo();
            adjustUserVo.setName(user.getName());
            adjustUserVo.setAdjust(adjusts.get(i).getAdjust());
            adjustUserVo.setId(adjusts.get(i).getId());
            adjustUserVos.add(adjustUserVo);
        }
        return adjustUserVos;
    }
}
