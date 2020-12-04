package com.wzk.controller;

import com.wzk.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: 顶层异常捕获类，处理所有controller抛出或访问controller时未被处理的异常。
 * @date 2020/11/15 17:56
 */
@ControllerAdvice
public class BaseExceptionHandler {

    /**
     * description: 处理所有异常类型.
     * TODO:
     * @date         2020/12/4 17:24
     * @author      DanRan233
     * @Param       [e]
     * @return      com.wzk.entity.Result
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(2001,"操作失败",e.getMessage());
    }
}
