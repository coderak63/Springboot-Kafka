package com.coderak63.springbootkafkademo.Kafka.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.coderak63.springbootkafkademo.Kafka.Model.KafkaModel;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "test-topic", groupId = "group-id")
	public void consume(KafkaModel kafkaModel) 
	{
	    System.out.println(kafkaModel.toString());
	}

}
