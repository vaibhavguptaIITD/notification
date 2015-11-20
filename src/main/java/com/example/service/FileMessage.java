package com.example.service;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FileMessage implements Serializable {
	
	private String fileId;
	
	private String status;
	
	public FileMessage(String fileId, String status){
		this.fileId = fileId;
		this.status = status;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
