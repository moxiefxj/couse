package com.fxj.course.config;

import com.fxj.course.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class HttpErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @ResponseBody
    @RequestMapping(path  = ERROR_PATH )
    public Result error(HttpServletRequest request, HttpServletResponse response){
        log.info("访问/error" + "  错误信息："  + response);
        Result result = new Result(1,String.valueOf(response.getStatus()),String.valueOf(response),null);
        return result;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}