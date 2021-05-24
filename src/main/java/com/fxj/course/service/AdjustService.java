package com.fxj.course.service;

import com.fxj.course.entity.Adjust;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fxj.course.entity.Classfiy;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-05-16
 */
public interface AdjustService extends IService<Adjust> {
    Integer update(Integer userId, HashMap<String, String> maps);
    List getAdjust();
}
