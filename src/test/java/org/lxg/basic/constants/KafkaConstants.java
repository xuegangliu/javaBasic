package org.lxg.basic.constants;

/**
 * @author: xuegangliu
 * @date: 8/22/2018 2:41 PM
 * @DES:
 * @version: v1.0
 */
public final class KafkaConstants {
    // producer
    public final static String PRODUCER_CONFIG_BROKER_LIST = "metadata.broker.list";
    public final static String PRODUCER_CONFIG_KEY_SERIALIZER = "kafka.serializer.StringEncodert";
    public final static String PRODUCER_CONFIG_VALUE_SERIALIZER = "kafka.serializer.StringEncoder";
    public final static String PRODUCER_CONFIG_REQUEST_REQUIRED_ACKS = "-1";
    public final static String PRODUCER_CONFIG_TOPIC = "hello_topic";

    //
}
