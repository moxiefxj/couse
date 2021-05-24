package com.fxj.course.service.impl;

import com.fxj.course.entity.Collect;
import com.fxj.course.mapper.CollectMapper;
import com.fxj.course.service.CollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 收藏表 服务实现类
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-04-10
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    @Autowired
    public CollectMapper collectMapper;
    @Override
    public Integer updateCollect(Integer userId, Integer courseId) {
        Collect collect = new Collect();
        collect.setCourseId(courseId);
        collect.setUserId(userId);
        Integer i = collectMapper.insert(collect);
        return i;
    }

    @Override
    public Integer delCollect(Integer userId, Integer courseId) {
        HashMap map = new HashMap();
        map.put("course_id",courseId);
        map.put("user_id",userId);
        Integer i = collectMapper.deleteByMap(map);
        return i;
    }

    @Override
    public Boolean checkCollect(Integer userId, Integer courseId) {
        HashMap map = new HashMap();
        map.put("course_id",courseId);
        map.put("user_id",userId);
        List list = collectMapper.selectByMap(map);
        if(list.size() != 0){
            return true;
        }
        return false;
    }

    @Override
    public List getCourseId(Integer userId) {
        HashMap map = new HashMap();
        map.put("user_id",userId);
        List list = new ArrayList();
        List<Collect> list1 = collectMapper.selectByMap(map);
        System.out.println(list1);
        for (int i = 0; i < list1.size(); i++) {
            list.add(list1.get(i).getCourseId());
        }
        return list;
    }
}
