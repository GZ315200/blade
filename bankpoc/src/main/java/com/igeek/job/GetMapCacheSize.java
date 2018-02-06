package com.igeek.job;

import com.igeek.cache.MessageCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Gyges Zean
 * @date 2018/2/2
 */
public class GetMapCacheSize implements Runnable {

    private Logger logger = LoggerFactory.getLogger(GetMapCacheSize.class);

    @Override
    public void run() {
        logger.info("get map size is:" + MessageCache.cache.size());
    }

    public static void start() {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new GetMapCacheSize(),2,3, TimeUnit.SECONDS);
    }

}
