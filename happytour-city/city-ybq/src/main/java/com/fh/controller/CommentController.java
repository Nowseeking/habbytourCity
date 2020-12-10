package com.fh.controller;

import com.fh.model.Comment;
import com.fh.service.CommentService;
import com.fh.utils.ServerRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comment")
@Api(tags = "评论")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //查询
    @RequestMapping("queryComment")
    public ServerRequest queryComment() {
        return commentService.queryComment ();
    }
    //id查询
    @RequestMapping("queryCommentById")
    public ServerRequest queryCommentById(Integer id) {
        return commentService.queryCommentById (id);
    }

    //新增
    @RequestMapping("addComment")
    public ServerRequest addComment(Comment comment) {
        return commentService.addComment (comment);
    }

    //修改
    @RequestMapping("updateComment")
    public ServerRequest updateComment(Comment comment) {
        return commentService.updateComment (comment);
    }

    //删除
    @RequestMapping("delComment")
    public ServerRequest delComment(Integer id) {
        return commentService.delComment (id);
    }

    //批量删除
    @RequestMapping("deleteBatch")
    public ServerRequest deleteBatch(@RequestParam("idArr") List<Integer> list) {
        return commentService.deleteBatch (list);
    }


}
