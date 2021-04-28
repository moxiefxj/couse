package com.fxj.course.service;

import com.fxj.course.entity.Collect;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 收藏表 服务类
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-04-10
 */
public interface CollectService extends IService<Collect> {
    //    添加收藏
    public Integer updateCollect(Integer userId,Integer courseId);
    //    取消收藏
    public Integer delCollect(Integer userId,Integer courseId);
//    判断是否收藏
    public  Boolean checkCollect(Integer userId,Integer courseId);
//
    public List getCourseId(Integer userId);
}
