package com.mt.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_word")
public class Word {

    @TableId(type = IdType.INPUT)
    private Integer id;
    private String introduction;
    private String readingVolume;
    private String collectionNum;
    private Integer userId;
    private Integer areaId;

    public Word(Integer id, String introduction, String readingVolume, String collectionNum, Integer userId, Integer areaId) {
        this.id = id;
        this.introduction = introduction;
        this.readingVolume = readingVolume;
        this.collectionNum = collectionNum;
        this.userId = userId;
        this.areaId = areaId;
    }

    public Word() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getReadingVolume() {
        return readingVolume;
    }

    public void setReadingVolume(String readingVolume) {
        this.readingVolume = readingVolume;
    }

    public String getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(String collectionNum) {
        this.collectionNum = collectionNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
