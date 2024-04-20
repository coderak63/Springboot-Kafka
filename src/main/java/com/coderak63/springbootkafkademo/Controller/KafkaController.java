package com.coderak63.springbootkafkademo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderak63.springbootkafkademo.Kafka.Model.KafkaModel;
import com.coderak63.springbootkafkademo.Kafka.Producer.MessageProducer;


@RestController
public class KafkaController {
	
	@GetMapping("/ping")
	public String ping() {
		return "Pinged successfully";
	}
	
	
	@Value("${kafkaTopic}")
	private String topicName;

	@Autowired
	private MessageProducer messageProducer;
	
	@PostMapping("/sendMessage")
	public ResponseEntity<?> sendMessage(@RequestBody KafkaModel kafkaModel) {
		try {
			messageProducer.sendMessage(topicName, kafkaModel);
			return new ResponseEntity<>("Message Sent successfully",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	

	



}
