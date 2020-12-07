package com.fh.config;

import com.fh.common.HandlerMemberReslove;
import com.fh.interceptor.IdempotenceInterceptor;
import com.fh.interceptor.MemberInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    public MemberInterceptor MemberInterceptor(){
        return new MemberInterceptor();
    }

    @Bean
    public IdempotenceInterceptor IdempotenceInterceptor(){
        return new IdempotenceInterceptor();
    }

    @Bean
    public HandlerMemberReslove handlerMemberResolve(){
        return new HandlerMemberReslove();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(MemberInterceptor()).addPathPatterns("/**").excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        registry.addInterceptor(IdempotenceInterceptor()).addPathPatterns("/**").excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");

    }

    //参数解析器
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(handlerMemberResolve());
        super.addArgumentResolvers(argumentResolvers);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        super.addResourceHandlers(registry);
    }

}
