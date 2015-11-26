package com.example.controllers;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.example.domain.NotificationContext;

@Controller
public class NotificationController {
	
	@Autowired
	private NotificationContext notificationContext;
	
	@RequestMapping(value="/notifications", method=RequestMethod.GET)
	@ResponseBody
	public DeferredResult<List<String>> getNotifications(HttpSession session){
		DeferredResult<List<String>> result = new DeferredResult<List<String>>(null, Collections.emptyList());
		notificationContext.addDeferredResult(result);
		 result.onCompletion(new Runnable() {
		    public void run() {
		    	notificationContext.removeDeferredResult(result);
		    }
		  });
		return result;
	}
	
	
	

}
