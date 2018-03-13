package com.igeek.job;


import com.igeek.bean.Message;
import com.igeek.cache.MessageCache;
import com.igeek.config.KafkaConfig;
import com.igeek.util.PropertiesUtils;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Gyges Zean
 * @date 2018/2/2
 */
public class ProducerMessage implements Runnable {

    private Logger logger = LoggerFactory.getLogger(ProducerMessage.class);

    private String TOPIC = PropertiesUtils.getProperty("topic");

    public void producerMessageInfo() {
        KafkaProducer producer = new KafkaProducer(KafkaConfig.getProducerProperties());
        for (Object key : MessageCache.cache.keySet()) {
            List<Message> messageList = MessageCache.cache.get(key);
            messageList.stream().filter(message -> !Objects.isNull(message)).forEach(message -> {
                producer.send(new ProducerRecord<>(TOPIC, key, message), new MyCallBack(System.currentTimeMillis(), key.toString(), message.toString()));
            });
        }

    }

    class MyCallBack implements Callback {

        private final long startTime;
        private final String key;
        private final String message;

        public MyCallBack(long startTime,

                          String key, String message) {
            this.startTime = startTime;
            this.key = key;
            this.message = message;
        }


        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (recordMetadata != null) {
                System.out.println("message (" + key + "," + message + ") sent to partition (" +
                        recordMetadata.partition() + ") ," + "offset (" + recordMetadata.offset() + ") in" + elapsedTime + "ms");
            } else {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        producerMessageInfo();
    }


    public void start() {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new ProducerMessage(), 10, 5, TimeUnit.SECONDS);
    }
}
