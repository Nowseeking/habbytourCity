package com.fh.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_comment")
public class Comment {
    @TableId
    private Integer comId;//（integer别名）
    private String content;//（longtext 评论内容）
    private Integer userId;//（评论人ID  integer）
    private Integer suffer;// （被评论人ID  integer）
    private Integer wordId;///（评论文档ID  integer）

    public Comment() {
    }

    public Comment(Integer comId, String content, Integer userId, Integer suffer, Integer wordId) {
        this.comId = comId;
        this.content = content;
        this.userId = userId;
        this.suffer = suffer;
        this.wordId = wordId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSuffer() {
        return suffer;
    }

    public void setSuffer(Integer suffer) {
        this.suffer = suffer;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }
}
