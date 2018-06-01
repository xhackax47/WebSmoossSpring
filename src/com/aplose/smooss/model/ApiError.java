package com.aplose.smooss.model;

import org.springframework.http.HttpStatus;

public class ApiError {
	private HttpStatus error;
	private String message;

	public HttpStatus getError() {
		return error;
	}

	public void setError(HttpStatus error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiError(HttpStatus status, String message) {
		this.error = status;
		this.message = message;
	}

}