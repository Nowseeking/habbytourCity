package com.fh.comment;

public enum Enum {
    SUCCESS(200 ,"操作成功"),
    ERROR(100 ,"操作失败"),
    LOGIN_ERROR(1000,"登陆超时"),
    TOKEN_ERROR(1001,"token异常，没有进方法")
    ;
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    Enum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
