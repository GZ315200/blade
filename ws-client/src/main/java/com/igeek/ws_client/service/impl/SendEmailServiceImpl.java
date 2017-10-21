package com.igeek.ws_client.service.impl;

import org.springframework.stereotype.Service;
import com.igeek.ws_client.pojo.SystemSendEmail;
import com.igeek.ws_client.service.SendEmailService;

/**
 * Created by Gyges on 2017/10/17
 */
@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Override
    public SystemSendEmail sendEmail(String token, String title, String content, String[] emailAddress) {
        SystemSendEmail sendEmail = new SystemSendEmail();
        sendEmail.setLoginResult("true");
        sendEmail.setSendFlag(new String[]{"SUCCESS"});
        return sendEmail;
    }
}
