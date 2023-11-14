package com.roytuts.spring.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// registry.addEndpoint("/websocket").setAllowedOrigins("*").withSockJS(); //
		// spring boot 2.x.x
		registry.addEndpoint("/websocket").setAllowedOrigins("http://localhost:4200").withSockJS(); // spring boot 3.x.x
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableStompBrokerRelay("/topic").setRelayHost("localhost").setRelayPort(61613).setClientLogin("admin")
				.setClientPasscode("admin");
		config.setApplicationDestinationPrefixes("/app");
	}

}
