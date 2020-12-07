package com.mt.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_userinfo")
public class Userinfo {

    @TableId(type = IdType.INPUT)
    private Integer id;

    private Integer userId;

    private Integer photoalbum;

    private Integer wordId;

    private String photo;

    private String introduce;

    public Userinfo(Integer id, Integer userId, Integer photoalbum, Integer wordId, String photo, String introduce) {
        this.id = id;
        this.userId = userId;
        this.photoalbum = photoalbum;
        this.wordId = wordId;
        this.photo = photo;
        this.introduce = introduce;
    }

    public Userinfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPhotoalbum() {
        return photoalbum;
    }

    public void setPhotoalbum(Integer photoalbum) {
        this.photoalbum = photoalbum;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
