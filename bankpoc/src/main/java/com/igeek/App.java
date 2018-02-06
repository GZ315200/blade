package com.igeek;


import com.igeek.job.GetMapCacheSize;
import com.igeek.job.ProducerMessage;
import com.igeek.service.SentMsgToKafkaWithJDBC;
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
        SentMsgToKafkaWithJDBC.getInstance().start();
        logger.info("start to collect the data...");
        PullQueue.getInstance().start();
        logger.info("start to producer message to kafka...");
        ProducerMessage.getInstance().start();
        GetMapCacheSize.start();
    }


}
