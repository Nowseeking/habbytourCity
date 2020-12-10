package com.fh.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.comment.SerResponse;
import com.fh.mapper.UserMapper;
import com.fh.model.User;
import com.fh.utils.JwtUtil;
import com.fh.utils.MD5Util;
import com.fh.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements  UserService {

    @Resource
    private UserMapper userMapper;

    //登录
    @Override
    public SerResponse login(User user) {
        //判断用户
        if (user == null) {
            return SerResponse.error("前端参数用户为null");
        }
        //判断用户名
        if(StringUtils.isBlank(user.getName())){
            return SerResponse.error("参数异常，用户名不完整");
        }
        //判用户密码
        if(StringUtils.isBlank(user.getPassword())){
            return SerResponse.error("参数异常，密码不完整");
        }
        //查询数据库对象
        QueryWrapper qw=new QueryWrapper();
        qw.eq("name",user.getName());

        User userDB = userMapper.selectOne(qw);

        if(userDB==null){
            return SerResponse.error("数据库用户对象为空");
        }
        //判断密码
        if(!MD5Util.verify(user.getPassword(),userDB.getPassword())){
            return SerResponse.error("密码匹配错误");
        }
        //jwt登录
        //数据库对象转json串，token加密
        String jsonString = JSON.toJSONString(userDB);
        //t生成的token
        String jwtToken = JwtUtil.sign(jsonString);
        //放入到redis中
        RedisUtil.setEx("token",jwtToken,1800);

        return SerResponse.success(jwtToken);
    }

    //注册
    @Override
    public SerResponse register(User user) {
        String code = RedisUtil.get(user.getPhone() + "");
        if(!user.getCode().toString().equals(code)){
            return SerResponse.error("验证码不匹配");
        }
        //判断用户
        if(user==null){
            return SerResponse.error("前端参数用户为null");
        }
        //判断用户名
        if(StringUtils.isBlank(user.getName())){
            return SerResponse.error("参数异常，用户名不完整");
        }
        //判用户密码
        if(StringUtils.isBlank(user.getPassword())){
            return SerResponse.error("参数异常，密码不完整");
        }
        //查询数据库对象
        QueryWrapper qw=new QueryWrapper();
        qw.eq("name",user.getName());
        User userDB = userMapper.selectOne(qw);
        if(userDB!=null){
            return SerResponse.error("该用户已被注册");
        }
        user.setPassword(MD5Util.generate(user.getPassword()));
        userMapper.insert(user);
        return SerResponse.success("注册成功");
    }
}

