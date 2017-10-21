package com.igeek.ws_server.model;

/**
 * Created by Gyges on 2017/10/21
 */
public class Response {

    private int code;
    private String msg;

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
