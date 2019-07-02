package com.rajbhar.exceptionhandler;

public class AgeNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AgeNotValidException(String msg)
	{
		super(msg);
	}

}
