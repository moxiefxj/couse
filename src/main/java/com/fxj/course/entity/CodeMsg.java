package com.fxj.course.entity;

import lombok.Data;

@Data
public class CodeMsg {
    private Integer code;
    private String msg;
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(50000, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(50001, "参数校验异常：%s");
    public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(50002, "请求非法");

    public CodeMsg(){

    }

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg fillAgs(Object ...args){
        int code = this.code;
        String message = String.format(this.msg,args);
        return new CodeMsg(code,message);
    }
}
