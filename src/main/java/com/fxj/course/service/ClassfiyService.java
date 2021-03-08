package com.fxj.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fxj.course.entity.Classfiy;

import java.util.List;

public interface ClassfiyService extends IService<Classfiy> {
    public List<Classfiy> selectAll();
}
