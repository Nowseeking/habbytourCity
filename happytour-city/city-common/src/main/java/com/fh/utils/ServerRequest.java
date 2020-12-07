package com.fh.utils;

/**
 * 接口开发 封装当前类是为了返回前台状态码的统一性
 */
public class ServerRequest {
    private Integer code;//定义返回前台的状态码
    private Object data;//定义返回前台的数据
    private String msg;//定义返回前台的状态信息


    //操作成功有数据，用于查询
    public static ServerRequest success(Object data){
        return new ServerRequest(ServerEnum.SUCCESS.getCode(), data, ServerEnum.SUCCESS.getMsg());
    }
    //操作成功无数据
    public static ServerRequest success(){
       return new ServerRequest(ServerEnum.SUCCESS.getCode(), ServerEnum.SUCCESS.getMsg());
    }

    //登录失败 返回的状态码
    public static ServerRequest loginError(){
        return new ServerRequest(ServerEnum.LOGIN_ERROR.getCode(), ServerEnum.LOGIN_ERROR.getMsg());
    }

    //操作失败 返回的状态码
    public static ServerRequest error(String msg){
        return new ServerRequest(ServerEnum.ERROR.getCode(),msg);
    }

    //操作失败无数据 返回的状态码
    public static ServerRequest error(){
        return new ServerRequest(ServerEnum.ERROR.getCode(), ServerEnum.ERROR.getMsg());
    }

    public ServerRequest() {
    }

    public ServerRequest(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public ServerRequest(Integer code,  String msg) {
        this.code = code;
        this.msg = msg;
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
