package com.example.exception;

public class AuthorNameNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AuthorNameNotFoundException(String message) {
		
		super(message);
	}
}
