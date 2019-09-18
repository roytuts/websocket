package com.roytuts.spring.websocket.service;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.roytuts.spring.websocket.vo.Message;

@Service
public class GreetingService {

	public Message getMessage() {
		Calendar c = Calendar.getInstance();
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
		StringBuilder sb = new StringBuilder();
		String message = "Have a Good Day";
		if (timeOfDay >= 0 && timeOfDay < 12) {
			message = "Good Morning";
		} else if (timeOfDay >= 12 && timeOfDay < 16) {
			message = "Good Afternoon";
		} else if (timeOfDay >= 16 && timeOfDay < 21) {
			message = "Good Evening";
		} else if (timeOfDay >= 21 && timeOfDay < 24) {
			message = "Good Night";
		}
		sb.append(message).append(" - ").append(generateString());
		return new Message(sb.toString());
	}

	private String generateString() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}

}
