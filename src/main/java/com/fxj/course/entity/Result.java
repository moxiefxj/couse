package com.fxj.course.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="返回值对象", description="")
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "接口调用成功或者失败")
    private Integer code = 0;

    @ApiModelProperty(value = "失败的具体code")
    private String errorCode = "";

    @ApiModelProperty(value = "需要传递的信息，例如错误信息")
    private String msg;

    @ApiModelProperty(value = "需要传递的数据")
    private T data;

    public Result(Integer code, String errorCode, String msg, T data) {
        this.code = code;
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
    }

    public Result(Object body) {
        this.data = (T) body;
    }
}
