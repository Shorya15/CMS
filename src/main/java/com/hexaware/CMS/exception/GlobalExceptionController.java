package com.hexaware.CMS.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(AlreadyExistException.class)
	public ResponseEntity<ErrorDetails>	handleAlreadyExistException(AlreadyExistException obj,WebRequest req)
	{
		ErrorDetails error=new ErrorDetails(LocalDate.now(),obj.getMessage(),req.getDescription(false),"AlreadyExistException");
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotExistException.class)
	public ResponseEntity<ErrorDetails> handleNotExistException(NotExistException obj,WebRequest req)
	{
		ErrorDetails error=new ErrorDetails(LocalDate.now(),obj.getMessage(),req.getDescription(false),"Not Exist Exception");
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResponseNotFoundException(ResourceNotFoundException obj,WebRequest req)
	{
		ErrorDetails error=new ErrorDetails(LocalDate.now(),obj.getMessage(),req.getDescription(false),"Response Not FoundException ");
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
