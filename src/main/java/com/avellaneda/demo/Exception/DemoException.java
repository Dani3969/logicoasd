package com.avellaneda.demo.Exception;


import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class DemoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	private String message;
	
	public DemoException (HttpStatus status, String message) {
		this.status =  status;
		this.message =  message;
	}
	
	
}
