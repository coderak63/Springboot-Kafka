package com.coderak63.springbootkafkademo.Kafka.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.coderak63.springbootkafkademo.Kafka.Model.KafkaModel;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, KafkaModel> kafkaTemplate;

    public void sendMessage(String topic, KafkaModel kafkaModel) {
        kafkaTemplate.send(topic, kafkaModel);
    }


}
