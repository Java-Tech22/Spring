package com.example.demo.exceptions;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}


}
