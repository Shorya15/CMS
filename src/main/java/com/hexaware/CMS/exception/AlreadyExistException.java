package com.hexaware.CMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class AlreadyExistException extends Exception{
	private String message;
	public AlreadyExistException(String message)
	{
		super(message);
	}

}
