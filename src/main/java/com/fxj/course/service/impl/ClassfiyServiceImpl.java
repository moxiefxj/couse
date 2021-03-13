package com.fxj.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fxj.course.entity.Classfiy;
import com.fxj.course.mapper.ClassfiyMapper;
import com.fxj.course.service.ClassfiyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassfiyServiceImpl extends ServiceImpl<ClassfiyMapper, Classfiy> implements ClassfiyService {
    @Autowired
    public ClassfiyMapper classfiyMapper;
    @Override
    public List<Classfiy> selectAll() {
        List<Classfiy> classfiys = classfiyMapper.selectList(null);
        return classfiys;
    }
}
