package com.avellaneda.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.avellaneda.demo.Exception.DemoException;
import com.avellaneda.demo.model.ErrorResponse;



@ControllerAdvice
public class ConfigCustom extends ResponseEntityExceptionHandler {

	@ExceptionHandler({DemoException.class})
	public ResponseEntity<ErrorResponse> MensajeError(DemoException exception){
		return new ResponseEntity<>( new ErrorResponse(exception.getStatus().value(), exception.getMessage(), true),exception.getStatus());
	}


	@ExceptionHandler({Exception.class})
	public ResponseEntity<ErrorResponse> MensajeGenerico(Exception exception){
		return new ResponseEntity<>( new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Hubo un error al procesar", true), HttpStatus.BAD_REQUEST);
	}


}
