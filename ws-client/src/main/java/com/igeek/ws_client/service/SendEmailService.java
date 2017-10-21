package com.igeek.ws_client.service;

import com.igeek.ws_client.pojo.SystemSendEmail;

/**
 * Created by Gyges on 2017/10/17
 */
public interface SendEmailService {

    /**
     *
     * @param token
     * @param title
     * @param content
     * @param emailAddress
     * @return
     */
    SystemSendEmail sendEmail(String token, String title, String content, String[] emailAddress);

}
