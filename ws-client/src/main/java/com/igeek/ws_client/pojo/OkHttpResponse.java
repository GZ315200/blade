package com.igeek.ws_client.pojo;

/**
 * Created by Gyges on 2017/10/20
 */
public class OkHttpResponse {

    private int code;
    private String body;

    public OkHttpResponse(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public OkHttpResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OkHttpResponse{");
        sb.append("code=").append(code);
        sb.append(", body='").append(body).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
