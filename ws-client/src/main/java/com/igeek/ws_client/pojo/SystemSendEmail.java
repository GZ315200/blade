package com.igeek.ws_client.pojo;

/**
 * Created by Gyges on 2017/10/17
 */
public class SystemSendEmail {

    private String loginResult;
    private String[] sendFlag;


    public SystemSendEmail() {
    }

    public SystemSendEmail(String loginResult, String[] sendFlag) {
        this.loginResult = loginResult;
        this.sendFlag = sendFlag;
    }

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }

    public String[] getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(String[] sendFlag) {
        this.sendFlag = sendFlag;
    }

}
