package com.mt.common;


public class ServerResponse {

    private  Integer code;
    private  String msg;
    private Object  data;


    public static ServerResponse success(Object data){
            return  new ServerResponse(ServerEnum.success.getCode(),data, ServerEnum.success.getMsg());
    }

    public static ServerResponse success(){
            return  new ServerResponse(ServerEnum.success.getMsg(), ServerEnum.success.getCode());
    }

    public static ServerResponse error(String msg){
        return  new ServerResponse(msg, ServerEnum.error.getCode());
    }

    public static ServerResponse error(){
        return  new ServerResponse(ServerEnum.error.getMsg(), ServerEnum.error.getCode());
    }

    public static ServerResponse LoginError(){
        return  new ServerResponse(ServerEnum.loginError.getMsg(), ServerEnum.loginError.getCode());
    }

    

    public ServerResponse(Object data) {
        this.data = data;
    }

    public ServerResponse(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public ServerResponse() {
    }

    public ServerResponse(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static ServerResponse tokenError(String message) {
        return new ServerResponse(message, ServerEnum.tokenError.getCode());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
