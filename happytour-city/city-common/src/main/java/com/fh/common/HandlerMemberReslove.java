package com.fh.common;

import com.fh.model.Member;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;


public class HandlerMemberReslove implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        MemberAnnotation parameterAnnotation = parameter.getParameterAnnotation(MemberAnnotation.class);
        if(parameterAnnotation!=null){
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest nativeRequest = (HttpServletRequest) webRequest.getNativeRequest();
        Member member = (Member) nativeRequest.getAttribute("member");

        //HttpSession session = (HttpSession) redisUtil.get("session");
       // Member member2 = (Member) session.getAttribute("member");
        return member;
    }
}

