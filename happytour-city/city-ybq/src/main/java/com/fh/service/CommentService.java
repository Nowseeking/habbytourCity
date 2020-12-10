package com.fh.service;


import com.fh.model.Comment;
import com.fh.utils.ServerRequest;

import java.util.List;

public interface CommentService {
    //查询
    ServerRequest queryComment();

    //新增
    ServerRequest addComment(Comment comment);

    //修改
    ServerRequest updateComment(Comment comment);

    //删除
    ServerRequest delComment(Integer id);

    //批量删除
    ServerRequest deleteBatch(List<Integer> list);

    ServerRequest queryCommentById(Integer id);
}
