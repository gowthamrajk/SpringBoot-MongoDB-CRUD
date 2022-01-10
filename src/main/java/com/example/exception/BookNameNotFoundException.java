package com.example.exception;

public class BookNameNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BookNameNotFoundException(String message) {
		
		super(message);
	}
}
