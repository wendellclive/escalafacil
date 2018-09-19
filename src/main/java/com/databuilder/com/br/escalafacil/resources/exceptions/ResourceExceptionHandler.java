package com.databuilder.com.br.escalafacil.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.databuilder.com.br.escalafacil.services.exceptions.ObjetcNotFoundException;



@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjetcNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjetcNotFoundException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

	}
}
