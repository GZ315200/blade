package com.igeek.ws_client.exception;

/**
 * Created by Gyges on 2017/10/20
 */
public class GeneralServiceException extends RuntimeException{

    private int code;
    private String msg;


    public GeneralServiceException() {
    }

    public GeneralServiceException(String message, int code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public GeneralServiceException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GeneralServiceException(String msg,Throwable cause) {
        super(cause);
        this.msg = msg;
    }

    public GeneralServiceException(Throwable cause) {
        super(cause);
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
