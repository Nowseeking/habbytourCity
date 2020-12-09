package com.fh.comment;

import com.alibaba.fastjson.JSON;
import com.fh.model.User;
import com.fh.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//登录拦截器
public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断该请求是否需要被拦截
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        login annotation = handlerMethod.getMethodAnnotation(login.class);
        if(annotation!=null){
            return true;
        }
        //获取请求的头部信息
        String authToken = request.getHeader("auth");
        //请求中无头部信息
        if(StringUtils.isBlank(authToken)){
            throw new AjaxException();
        }
        //如果token解析失败
        String token = JwtUtil.verify(authToken);
        if(StringUtils.isBlank(token)){
            throw new AjaxException();
        }
        User userDB = JSON.parseObject(token, User.class);
        request.getSession().setAttribute("user",userDB);
        return true;
    }

}
