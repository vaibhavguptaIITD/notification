package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NotificationContext {
	
	private List<DeferredResult<List<String>>> deferredResults;
	
	public NotificationContext(){
		this.deferredResults = new ArrayList<DeferredResult<List<String>>>();
	}

	public List<DeferredResult<List<String>>> getDeferredResults() {
		return deferredResults;
	}

	public void setDeferredResults(List<DeferredResult<List<String>>> deferredResults) {
		this.deferredResults = deferredResults;
	}
	
	public void removeDeferredResult(DeferredResult<List<String>> result){
		deferredResults.remove(result);
	}
	
	public void addDeferredResult(DeferredResult<List<String>> result){
		deferredResults.add(result);
	}

}
