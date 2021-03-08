package com.fxj.course.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 *
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Classfiy对象", description="")
public class Classfiy implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "分类")
    private String classfiy;

    @ApiModelProperty(value = "分类第一层")
    private String classfiy_level1;

    @ApiModelProperty(value = "分类第二层")
    private String classfiy_level2;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(update = "now()")
    private LocalDateTime updateTime;
}
