package com.doit.demo.graalvmcloudnativeserver.config;

import java.util.Map;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.doit.demo.graalvmcloudnativeserver.chat.ChatMessage;
import com.doit.demo.graalvmcloudnativeserver.chat.MessageType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

	private final SimpMessageSendingOperations messagingTemplate;

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		Map<String, Object> attributes = headerAccessor.getSessionAttributes();
		if (attributes != null && !attributes.isEmpty()) {
			String username = (String) attributes.get("username");
			if (username != null) {
				log.info("user disconnected: {}", username);
				var chatMessage = ChatMessage.builder().type(MessageType.LEAVE).sender(username).build();
				messagingTemplate.convertAndSend("/topic/public", chatMessage);
			}
		}
	}

}