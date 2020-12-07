package com.mt.controller;

import com.fh.utils.ServerRequest;
import com.mt.model.Userinfo;
import com.mt.service.UserinfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("userinfo")
public class UserinfoController {

    @Resource
    private UserinfoService userinfoService;

    //查询用户个人信息（用户ID）
    @RequestMapping("query")
    public ServerRequest query(Integer id){

        return userinfoService.query(id);
    }

    //修改用户个人信息 （用户信息 包括ID,头像,个人简介）
    @RequestMapping("updateinfo")
    public ServerRequest updateinfo(Userinfo userinfo){
        return userinfoService.updateinfo(userinfo);
    }

    //查询用户收藏的文档 (用户ID)
    @RequestMapping("queryCollection")
    public ServerRequest queryCollection(Integer id){
        return userinfoService.queryCollection(id);
    }


    //收藏文档 (收藏人ID 文档ID )
    @RequestMapping("collectWord")
    public ServerRequest collectWord(){
        return ServerRequest.success();
    }


    //移除用户收藏的文档（用户ID,文档ID）
    @RequestMapping("deleteCollection")
    public ServerRequest deleteCollection(Userinfo userinfo){
        return userinfoService.deleteCollection(userinfo);
    }

}
