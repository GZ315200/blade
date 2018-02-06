package com.igeek.controller;

import com.igeek.bean.Message;


/**
 * @author Gyges Zean
 * @date 2018/2/2
 */
public interface MessageController {

    public void doBefore(Message message);

    public void doAfter(Message message);

}
