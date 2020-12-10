package com.fh.comment;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloboeException {

    @ExceptionHandler(AjaxException.class)
    public SerResponse ajaxException(AjaxException ajax){
        //ajax.printStackTrace();
        return SerResponse.login_error();
    }

    @ExceptionHandler(Exception.class)
    public SerResponse exeCeption(Exception e){
        e.printStackTrace();
        return SerResponse.error(e.getMessage());
    }
}
