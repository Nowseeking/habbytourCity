package com.fh.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.fh.comment.SerResponse;
import com.fh.comment.login;
import com.fh.model.User;
import com.fh.service.UserService;
import com.fh.utils.RedisUtil;
import com.fh.utils.SmsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("user")
@RestController
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("login")
    @login
    public SerResponse login(User user){
        return  userService.login(user);
    }

    @RequestMapping("register")
    @login
    public SerResponse register(User user){
        return  userService.register(user);
    }

    //验证验证码
    @RequestMapping("message")
    @login
    public SerResponse message(User user) throws Exception {
        //15554221009
        SendSmsResponse preCode = SmsUtils.sendSms(user.getPhone());
        if(preCode !=null && preCode.getCode().equals("OK")){
            RedisUtil.setEx(user.getPhone(),preCode.getMessage()+"",60);
            return SerResponse.success("获取验证码成功");
        }else{
            return SerResponse.error("获取验证码失败");
        }
    }
    @RequestMapping("quitUser")
    public SerResponse quitUser(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        String token = RedisUtil.get("token");
        if(StringUtils.isNotBlank(token)){
            RedisUtil.del("token");
        }
        return SerResponse.success("退出登陆成功");
    }
}
