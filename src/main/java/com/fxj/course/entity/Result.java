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
    private Integer code ;

    @ApiModelProperty(value = "需要传递的信息，例如错误信息")
    private String msg;

    @ApiModelProperty(value = "需要传递的数据")
    private T data;

//    成功时调用
    public static <T> Result<T> success(T data,Integer code) {
        return new Result<T>(data,code);
    }
//    失败时调用
    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<T>(codeMsg);
    }
    private Result(T data,Integer code) {
        this.data = data;
        this.code = code;
    }
    private Result(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public Result(CodeMsg codeMsg) {
        if(codeMsg != null){
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }
}
