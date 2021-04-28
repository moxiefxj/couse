package com.fxj.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fxj.course.entity.Classfiy;
import com.fxj.course.entity.ClassfiyCourseVo;
import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.List;

public interface ClassfiyService extends IService<Classfiy> {
//    查询出所有的分类
    public List<Classfiy> selectAll();

//    查出第一层分类
    public List<Classfiy> selectPrimary();
//    新增第一层分类
    public Integer updatePrimary(HashMap<String,String> map);
//    删除第一层分类
    public Integer delPrimary(HashMap<String, Integer> map);

//    查询第二层分类
    public List<Classfiy> getClassfiySecond(HashMap<String, Integer> map);
//    修改分类名称
    public Integer modifyClassfiy(HashMap<String,String> map);

//    根据第二层分类id查询出此id之下所有分类id
    public List getClassfiyIds(String id);

}
