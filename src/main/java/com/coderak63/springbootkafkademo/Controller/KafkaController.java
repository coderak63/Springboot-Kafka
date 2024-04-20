package com.coderak63.springbootkafkademo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
	
	@GetMapping("/ping")
	public String ping() {
		return "Pinged successfully";
	}
}
