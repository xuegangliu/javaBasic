package org.lxg.basic.jms.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * Created by 刘雪岗 on 2017/1/21.
 */
public class KafkaProducer {
    private final Producer<String, String> producer;
    public final static String TOPIC = "hello_topic";

    private KafkaProducer(){
        Properties props = new Properties();
        //此处配置的是kafka的端口
        props.put("metadata.broker.list", "127.0.0.1:9092");

        //配置value的序列化类
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        //配置key的序列化类
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");

        // 0表示producer无需等待leader的确认
        // 1代表需要leader确认写入它的本地log并立即确认
        // -1代表所有的备份都完成后确认。 仅仅for sync
        props.put("request.required.acks","-1");

        producer = new Producer<String, String>(new ProducerConfig(props));
    }

    void produce() {
        int messageNo = 1000;
        final int COUNT = 10000;

        while (messageNo < COUNT) {
            String key = String.valueOf(messageNo);
            String data = "hello kafka message " + key;
            producer.send(new KeyedMessage<String, String>(TOPIC, key ,data));
            System.out.println(data);
            messageNo ++;
        }
    }

    public static void main( String[] args ) {
        new KafkaProducer().produce();
    }
}
