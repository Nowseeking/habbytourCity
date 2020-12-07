package com.fh.interceptor;


import com.alibaba.fastjson.JSON;
import com.fh.common.IgnoreLogin;
import com.fh.common.RuntimeExceptions;
import com.fh.model.Member;
import com.fh.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       HandlerMethod handler1 = (HandlerMethod) handler;
        IgnoreLogin methodAnnotation = handler1.getMethodAnnotation(IgnoreLogin.class);
        if(methodAnnotation != null){
            return true;
        }

        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            throw new RuntimeExceptions();
        }

        /*Member member1 = (Member) request.getSession().getAttribute("member");
        if(member1==null){
            throw new RuntimeExceptions();
        }*/

        String verify = JwtUtil.verify(token);
        if (StringUtils.isBlank(verify)){
            throw new RuntimeExceptions();
        }

        Member member = JSON.parseObject(verify, Member.class);
        request.setAttribute("member",member);

        return true;
    }
}
