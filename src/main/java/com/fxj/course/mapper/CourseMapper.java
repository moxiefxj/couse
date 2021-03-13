package com.fxj.course.mapper;

import com.fxj.course.entity.ClassfiyCourseVo;
import com.fxj.course.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-03-09
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {
    /**
     * @parm 分类名
     * @Return
     */
    @Select("SELECT course.id,course.classfiy_id,classfiy.classfiy_level1,classfiy.classfiy_level2,course.course_name,course.course_img,course.teacher" +
            " from classfiy,course " +
            "where classfiy.id=course.classfiy_id and classfiy.classfiy=#{classfiy}")
    List<ClassfiyCourseVo> getCourseClassfiyList(String classfiy);

    /**
     * 根据level2 查询
     * @param level1
     * @return
     */
    @Select("SELECT course.id,course.classfiy_id,classfiy.classfiy_level1,classfiy.classfiy_level2,course.course_name,course.course_img,course.teacher" +
            " from classfiy,course " +
            "where classfiy.id=course.classfiy_id and classfiy.classfiy_level1=#{level1}")
    List<ClassfiyCourseVo> getCourseLevel1List(String level1);

    /**
     * 根据level2 查询
     * @param level2
     * @return
     */
    @Select("SELECT course.id,course.classfiy_id,classfiy.classfiy_level1,classfiy.classfiy_level2,course.course_name,course.course_img,course.teacher" +
            " from classfiy,course " +
            "where classfiy.id=course.classfiy_id and classfiy.classfiy_level2=#{level2}")
    List<ClassfiyCourseVo> getCourseLevel2List(String level2);
}
