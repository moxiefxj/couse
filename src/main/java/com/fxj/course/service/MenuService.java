package com.fxj.course.service;

import com.fxj.course.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 目录表 服务类
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-03-09
 */
public interface MenuService extends IService<Menu> {

//    查找目录list
    public List<Menu> selectList(String id);
//    新增目录
    public Integer addMenu(HashMap<String,String> map);
//    查找章节目录
    public List selectChapterList(HashMap<String,String> map);
//    删除目录
    public Integer delMenu(String id);
//    修改目录
    public Integer modifyMenu(HashMap<String,String> map);
}
