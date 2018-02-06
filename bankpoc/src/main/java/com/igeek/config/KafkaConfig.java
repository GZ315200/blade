package com.igeek.config;

import com.igeek.util.PropertiesUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.util.Properties;

/**
 * @author Gyges Zean
 * @date 2018/2/2
 */
public class KafkaConfig {

    private static String BOOTSTRAP_SERVERS = PropertiesUtils.getProperty("bootstrap.servers");

    private static String GROUP_ID = PropertiesUtils.getProperty("group.id");

    public static Properties getProducerProperties() {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
//        props.put("security.protocol", "SASL_PLAINTEXT");
//        props.put("sasl.mechanism", "PLAIN");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("sasl.jaas.config","/Users/mazean/project/igeek/src/main/java/org/unistacks/kafka_client_jaas.conf");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }


    public static Properties getConsumerProperties() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID+System.currentTimeMillis());
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "60000");
//        props.put("security.protocol", "SASL_PLAINTEXT");
//        props.put("sasl.mechanism", "PLAIN");
//        props.put("sasl.jaas.config","/Users/mazean/project/igeek/src/main/java/org/unistacks/kafka_client_jaas.conf");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        return props;
    }

}
