package com.chegaai;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chegaai.commons.erros.ErroInesperado;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseBody
	public ErroInesperado exceptionInesperada(DataIntegrityViolationException ex) {
		return new ErroInesperado(ex.getMessage());
	}
	
}
