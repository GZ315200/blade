package com.igeek.ws_client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.igeek.ws_client.pojo.SystemSendEmail;
import com.igeek.ws_client.service.SendEmailService;

import javax.annotation.Resource;

/**
 * Created by Gyges on 2017/10/17
 * @author mazean
 */
@RestController
public class SendEmailController {

    @Resource
    private SendEmailService sendEmailService;

    @RequestMapping(value = "send",method = RequestMethod.GET)
    public SystemSendEmail getSendEmailStatus(String token, String title, String content, String[] emailAddress) {
        return sendEmailService.sendEmail(token, title, content, emailAddress);
    }
}
