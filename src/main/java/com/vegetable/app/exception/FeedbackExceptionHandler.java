package com.vegetable.app.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FeedbackExceptionHandler extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FeedbackExceptionHandler(String message) {
		super(message);

	}

	public FeedbackExceptionHandler() {

	}
}
