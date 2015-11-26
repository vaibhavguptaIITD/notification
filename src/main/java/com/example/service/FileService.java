package com.example.service;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	
	//@Autowired
	private  RabbitTemplate rabbitTemplate;
	
	public void process() throws InterruptedException{
		String fileId = UUID.randomUUID().toString();
		//send pending status
		publishStatus("pending", fileId);
		//sleep
		Thread.sleep(1*1000);
		//send processing status
		publishStatus("processing", fileId);
		//sleep
		Thread.sleep(1*1000);
		//send success status
		publishStatus("success", fileId);
		//
	}

	private void publishStatus(String status, String fileId) {
		
		rabbitTemplate.convertAndSend("file-processing", new FileMessage(fileId, status));
	}

}
