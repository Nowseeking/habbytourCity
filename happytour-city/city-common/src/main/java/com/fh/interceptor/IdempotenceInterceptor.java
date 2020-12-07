package com.fh.interceptor;


import com.fh.common.Idempotence;
import com.fh.common.IdempotenceNeedExceptions;
import com.fh.utils.RedisUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdempotenceInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       HandlerMethod handler1 = (HandlerMethod) handler;
        Idempotence idempotence = handler1.getMethodAnnotation(Idempotence.class);
        if(idempotence == null){
            return  true;
        }

        String token = request.getHeader("mtoken");
        boolean exists = redisUtil.exists(token);
        if(!exists){
            throw new IdempotenceNeedExceptions();
        }

        //删除mtoken
        long flag = redisUtil.removes(token);
        if(flag != 1){
            throw new IdempotenceNeedExceptions();
        }

        return true;
    }
}
