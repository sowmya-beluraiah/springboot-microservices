package com.sowmya.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import lombok.Data;

@Data
public class ExceptionResponse {
	Date timestamp;
	String message;
	String details;
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
}
