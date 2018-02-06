package com.igeek.ws_client.util;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Gyges on 2017/10/30
 */
public class Main {

//    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    private static final Logger logger = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.debug("Debug Message Logged");
        logger.info("info Message Logged");
        logger.error("Error Message Logged!!!", new NullPointerException("NullError"));
    }
}
