package com.sowmya.rest.webservices.restfulwebservices.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
	String message;

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}

}
