package com.fh.comment;

public class SerResponse {

    private Integer code;
    private String message;
    private Object data;


    //查询，回显
    public static SerResponse success(Object data) {
        return new SerResponse(Enum.SUCCESS.getCode(), Enum.SUCCESS.getMessage(),data);
    }

    //删除，批删
    public static SerResponse success() {
        return new SerResponse(Enum.SUCCESS.getCode(), Enum.SUCCESS.getMessage());
    }

    public static SerResponse error(String message) {
        return new SerResponse(Enum.ERROR.getCode(),message);
    }

    public static SerResponse error() {
        return new SerResponse(Enum.ERROR.getCode(), Enum.ERROR.getMessage());
    }

    public static SerResponse login_error() {
        return new SerResponse(Enum.LOGIN_ERROR.getCode(), Enum.LOGIN_ERROR.getMessage());
    }
    public static SerResponse token_error() {
        return new SerResponse(Enum.TOKEN_ERROR.getCode(), Enum.LOGIN_ERROR.getMessage());
    }


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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SerResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public SerResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
