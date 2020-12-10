package com.fh.service;

import com.fh.mapper.CommentMapper;
import com.fh.model.Comment;
import com.fh.utils.ServerRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    //查询
    public ServerRequest queryComment() {
        List<Comment> list = commentMapper.selectList (null);
        return ServerRequest.success (list);
    }

    @Override
    //新增
    public ServerRequest addComment(Comment comment) {
        commentMapper.insert (comment);
        return ServerRequest.success ();
    }

    @Override
    //修改
    public ServerRequest updateComment(Comment comment) {
        commentMapper.updateById (comment);
        return ServerRequest.success ();
    }

    @Override
    //删除
    public ServerRequest delComment(Integer id) {
        commentMapper.deleteById (id);
        return ServerRequest.success ();
    }

    @Override
    //批量删除
    public ServerRequest deleteBatch(List<Integer> list) {

        commentMapper.deleteBatchIds (list);

        return ServerRequest.success ();
    }

    @Override
    public ServerRequest queryCommentById(Integer id) {
        Comment comment = commentMapper.selectById (id);
        return ServerRequest.success (comment);
    }

}
