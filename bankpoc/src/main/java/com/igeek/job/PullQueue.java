package com.igeek.job;


import com.google.common.collect.Lists;
import com.igeek.bean.Message;
import com.igeek.cache.MessageCache;
import com.igeek.cache.Queue;
import com.igeek.controller.MessageController;
import com.igeek.service.SentMsgToKafkaWithJDBC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author Gyges Zean
 * @date 2018/2/2
 */
public class PullQueue implements Runnable {

    private Logger logger = LoggerFactory.getLogger(PullQueue.class);

    private List<Message> messageList = Lists.newArrayList();

    private static int SIZE = 100;



    private static class PullQueueHolder {
        private static final PullQueue PULL_QUEUE = new PullQueue();

        private PullQueueHolder() {
        }
    }

    private PullQueue() {

    }

    public static synchronized PullQueue getInstance() {
        return PullQueueHolder.PULL_QUEUE;
    }

    /**
     * 拉取数据至数据接口
     * @param messageController
     */
    private void pullMessage(MessageController messageController) {
            if (Queue.queue.size() > 0) {
                Queue.queue.parallelStream().filter(message -> !Objects.isNull(message)).forEach(messageController::doBefore);
            }
    }

    @Override
    public void run() {
        pullMessage(new MessageController() {
            @Override
            public void doBefore(Message message) {

            }
            @Override
            public void doAfter(Message message) {
                logger.info("message content is :",message.toString());
            }

            @Override
            public void doBefore(List<Message> messages) {
                if (messages.size() == SIZE) {
//                    logger.info("the current message size is :" + messages.size());
                    MessageCache.cache.put(ThreadLocalRandom.current().nextInt(), messages);
                }
            }
        });
    }

    /**
     * 启动线程将数据放入map缓存中
     */
    public void start() {
       Executors.newScheduledThreadPool(1).scheduleAtFixedRate(PullQueue.getInstance(),10,5, TimeUnit.SECONDS);
    }


}
