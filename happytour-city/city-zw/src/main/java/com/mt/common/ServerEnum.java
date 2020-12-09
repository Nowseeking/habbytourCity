package com.mt.common;

public enum ServerEnum {
    success(200,"操作成功"),
    error(1001,"操作失败"),
    loginError(10086,"登录失败,宝贝"),
    tokenError(1003,"有问题喽"),
    ;

    private  Integer code;
    private  String msg;

    ServerEnum() {
    }

    ServerEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
