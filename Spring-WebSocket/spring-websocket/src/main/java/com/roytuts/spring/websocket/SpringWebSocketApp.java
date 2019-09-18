package com.roytuts.spring.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.roytuts.spring.websocket")
public class SpringWebSocketApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebSocketApp.class, args);
	}

}
