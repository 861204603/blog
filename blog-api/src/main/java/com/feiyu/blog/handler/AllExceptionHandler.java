package com.feiyu.blog.handler;

import com.feiyu.blog.vo.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class AllExceptionHandler {

    //处理异常
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        e.printStackTrace();;
        return Result.fail(-999, "系统异常");
    }
}
