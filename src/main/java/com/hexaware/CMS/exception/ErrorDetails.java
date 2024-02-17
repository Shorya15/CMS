package com.hexaware.CMS.exception;

import java.time.LocalDate;

public class ErrorDetails {
	private LocalDate timestamp;
	private String message;
	private String path;
	private String errorCode;
	
	public ErrorDetails() {
		super();
	}

	public ErrorDetails(LocalDate timestamp, String message, String path, String errorCode) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
		this.errorCode = errorCode;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		errorCode = errorCode;
	}
	
	
}
