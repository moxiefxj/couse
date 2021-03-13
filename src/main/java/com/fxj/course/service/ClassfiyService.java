package com.fxj.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fxj.course.entity.Classfiy;
import com.fxj.course.entity.ClassfiyCourseVo;

import java.util.List;

public interface ClassfiyService extends IService<Classfiy> {
//    查询出所有的分类
    public List<Classfiy> selectAll();

}
