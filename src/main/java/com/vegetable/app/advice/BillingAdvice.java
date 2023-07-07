package com.vegetable.app.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vegetable.app.exception.BillNotFoundException;
import com.vegetable.app.exception.NoSuchBillException;

@ControllerAdvice
public class BillingAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BillNotFoundException.class)
	public ResponseEntity<String> handleBillNotFoundf(BillNotFoundException billNotFoundException)
	{
		return new ResponseEntity<String>("This bill does not exist" , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchBillException.class)
	public ResponseEntity<String> handleNoSuchBillFound(NoSuchBillException noSuchBillException)
	{
		return new ResponseEntity<String>("Bill with given id doesn't exist",HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status ,WebRequest request )
	{
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.toList());
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}

}
