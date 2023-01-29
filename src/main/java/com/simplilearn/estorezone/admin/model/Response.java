package com.simplilearn.estorezone.admin.model;

import java.util.Date;

public class Response {
	        
	private String status;
	private String message;
	private Date timestamp = new Date();
	private Object data;
	
	//default constructor
	public Response() {
		super();
	}

	//parameterized constructor
	public Response(String status, String message, Date timestamp, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = new Date();
		this.data = data;
	}

	//getter and setter methods
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = new Date();
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}

	//override to string
	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + ", timestamp=" + timestamp + ", data=" + data
				+ "]";
	}
}
