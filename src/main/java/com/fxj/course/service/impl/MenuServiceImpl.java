package com.fxj.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fxj.course.entity.Menu;
import com.fxj.course.mapper.MenuMapper;
import com.fxj.course.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 目录表 服务实现类
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-03-09
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    public MenuMapper menuMapper;
    @Override
    public List<Menu> selectList(String id) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("course_id",id);
        List<Menu> menus = menuMapper.selectByMap(map);
        return menus;
    }

    @Override
    public Integer addMenu(HashMap<String, String> map) {
        Menu menu = new Menu();
        menu.setSection(map.get("section"));
        menu.setChapter(map.get("chapter"));
        menu.setCourseUrl(map.get("course_url"));
        menu.setCourseId(Integer.parseInt(map.get("course_id")));
        Integer i = menuMapper.insert(menu);
        return i;
    }

    @Override
    public List selectChapterList(HashMap<String, String> map) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("DISTINCT chapter").eq("course_id",map.get("id"));
        List list = menuMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public Integer delMenu(String id) {
        Integer i = menuMapper.deleteById(id);
        return i;
    }

    @Override
    public Integer modifyMenu(HashMap<String, String> map) {
        Menu menu = new Menu();
        menu.setId(Integer.parseInt(map.get("id")));
        menu.setSection(map.get("section"));
        menu.setChapter(map.get("chapter"));
        Integer i = menuMapper.updateById(menu);
        return i;
    }

    @Override
    public List<Menu> getSectionList(HashMap<String, String> map) {
        HashMap map1 = new HashMap();
        map1.put("chapter",map.get("chapter"));
        List<Menu> list = menuMapper.selectByMap(map1);
        return list;
    }
}
