package com.fxj.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 收藏表
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Collect对象", description="收藏表")
public class Collect implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "课程id")
    private Integer courseId;


}
