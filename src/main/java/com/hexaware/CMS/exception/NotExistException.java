package com.hexaware.CMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NotExistException extends Exception{

	private String msg; 
	public NotExistException(String msg)
	{
	super(msg);
	}
	}
