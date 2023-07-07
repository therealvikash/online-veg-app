package com.vegetable.app.exception;

public class AdminNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private String message;
	public AdminNotFoundException(String  message)
	{
		super(message);
    }
	

}
