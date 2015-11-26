package com.example.listeners;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import com.example.domain.NotificationContext;
import com.example.domain.NotificationEvent;

@Component
public class NotificationSessionListener{
	
	private Map<String, NotificationContext> userNotificationContexts = new HashMap<String, NotificationContext>();
	
	@Autowired
	private NotificationContext notificationContext;
	
	@EventListener
    public void onAuthenticationSuccess(InteractiveAuthenticationSuccessEvent event) {
		Authentication auth = event.getAuthentication();
		if(auth != null && auth.isAuthenticated()){
			userNotificationContexts.put("user", notificationContext);
		}
        
    }
	
	@EventListener
	public void removeNotificationContext(HttpSessionDestroyedEvent httpSessionDestroyedEvent){
		List<SecurityContext> contexts = httpSessionDestroyedEvent.getSecurityContexts();
		for(SecurityContext context : contexts){
			Authentication auth = context.getAuthentication();
			if(auth != null && auth.isAuthenticated()){
				userNotificationContexts.remove("user");
			}
		}
	}
	
	
	
	@EventListener
	public void onNotification(NotificationEvent notificationEvent){
		NotificationContext notificationContext = userNotificationContexts.get(notificationEvent.getUsername());
		if(notificationContext != null){
			List<DeferredResult<List<String>>> results = notificationContext.getDeferredResults();
			for(DeferredResult<List<String>> result : results){
				result.setResult(notificationEvent.getMessage());
			}
		}
		else{
			//Do something about notifications which have not yet been given to user
		}
	}

}
