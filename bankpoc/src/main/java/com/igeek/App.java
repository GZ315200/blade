package com.igeek;


import com.igeek.handler.HandlerMysqlDataService;
import com.igeek.job.GetMapCacheSize;
import com.igeek.job.ProducerMessage;

import com.igeek.job.PullQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 */
public class App {

    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("start to query the DB data...");
        new HandlerMysqlDataService().start();
        logger.info("start to collect the data...");
        new PullQueue().start();
        logger.info("start to producer message to kafka...");
        new ProducerMessage().start();
        GetMapCacheSize.start();
    }


}
