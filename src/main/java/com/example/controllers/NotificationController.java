package com.example.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.example.service.FileService;

@Controller
public class NotificationController {
	
	@Autowired
	private FileService fileService; 
	
	private DeferredResult<List<String>> result; 
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(){
		return "index";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.GET)
	public void process() throws InterruptedException{
		fileService.process();
	}
	
	@RequestMapping(value="/notifications", method=RequestMethod.GET)
	@ResponseBody
	public DeferredResult<List<String>> getNotifications(){
		result = new DeferredResult<List<String>>(null, Collections.emptyList());
		return result;
	}
	
	@RequestMapping(value="/updateNotification", method=RequestMethod.GET)
	public void updateNotification(){
		List<String> notifications = new ArrayList<String>();
		notifications.add("Notification " + Math.random());
		result.setResult(notifications);
	}

}
