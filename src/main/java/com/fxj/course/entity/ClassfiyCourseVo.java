package com.fxj.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Classfiy与course对象", description="")
public class ClassfiyCourseVo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "分类id")
    private Integer classfiyId;

    @ApiModelProperty(value = "分类名")
    private String name;

    @ApiModelProperty(value = "课程名")
    private String courseName;

    @ApiModelProperty(value = "课程图片")
    private String courseImg;

    @ApiModelProperty(value = "讲师")
    private String teacher;
}
