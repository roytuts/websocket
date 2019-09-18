package com.roytuts.spring.websocket.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.websocket.service.GreetingService;
import com.roytuts.spring.websocket.vo.Message;

@RestController
public class GreetingRestController {

	@Autowired
	private GreetingService greetingService;

	@MessageMapping("/hello")
	@SendTo("/topic/greeting")
	public Message greeting() {
		return greetingService.getMessage();
	}

}
