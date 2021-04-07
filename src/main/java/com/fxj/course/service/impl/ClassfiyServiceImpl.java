package com.fxj.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fxj.course.entity.Classfiy;
import com.fxj.course.mapper.ClassfiyMapper;
import com.fxj.course.service.ClassfiyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassfiyServiceImpl extends ServiceImpl<ClassfiyMapper, Classfiy> implements ClassfiyService {
    @Autowired
    public ClassfiyMapper classfiyMapper;
    @Override
    public List<Classfiy> selectAll() {
        List<Classfiy> classfiys = classfiyMapper.selectList(null);
        return classfiys;
    }

    @Override
    public List<Classfiy> selectPrimary() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("depth","1");
        List<Classfiy> classfiys = classfiyMapper.selectByMap(map);
        return classfiys;
    }

    @Override
    public Integer updatePrimary(HashMap<String, String> map) {
        Classfiy classfiy = new Classfiy();
        classfiy.setName(map.get("name"));
        classfiy.setDepth(map.get("depth"));
        classfiy.setParentId(map.get("parentId"));
        Integer b = classfiyMapper.insert(classfiy);
        return b ;
    }

    @Override
    public Integer delPrimary(HashMap<String, Integer> map) {
        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("parent_id",map.get("id"));
        List<Classfiy> classfiys = classfiyMapper.selectByMap(map1);
        if(classfiys.size() == 0){
            Integer i = classfiyMapper.deleteById(map.get("id"));
            return i;
        }else {
            return -1;
        }

    }

    @Override
    public List<Classfiy> getClassfiySecond(HashMap<String, Integer> map) {
        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("parent_id",map.get("parentId"));
        List<Classfiy> classfiys = classfiyMapper.selectByMap(map1);
        return classfiys;
    }

    @Override
    public Integer modifyClassfiy(HashMap<String, String> map) {
        Classfiy classfiy = new Classfiy();
        classfiy.setId((long) Integer.parseInt(map.get("id")));
        classfiy.setName(map.get("name"));
        Integer i = classfiyMapper.updateById(classfiy);
        return i;
    }


}
