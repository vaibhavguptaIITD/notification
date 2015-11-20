package com.example.service;

public class FileStatusReceiver {
	
	public void handleMessage(FileMessage fileMessage) {
		System.out.println("Received <File Id " + fileMessage.getFileId() + " Status: "+ fileMessage.getStatus()+">");
	}

}
