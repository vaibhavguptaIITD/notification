package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.NotificationEvent;

@Controller
public class PublishNotificationController {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	

	@RequestMapping(value="/updateNotification", method=RequestMethod.GET)
	public void updateNotification(){
		List<String> notifications = new ArrayList<String>();
		notifications.add("Notification " + Math.random());
		NotificationEvent notificationEvent = new NotificationEvent("user",notifications);
		publisher.publishEvent(notificationEvent);
	}
}
