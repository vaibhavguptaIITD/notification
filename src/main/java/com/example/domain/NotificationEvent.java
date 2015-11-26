package com.example.domain;

import java.util.List;

import org.springframework.context.ApplicationEvent;

public class NotificationEvent{
	
	public NotificationEvent(String username, List<String> message) {
		this.username = username;
		this.message = message;
	}

	private String username;
	
	private List<String> message;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}


}
