package com.chegaai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UsuarioNaoAutenticadoException extends RuntimeException {
  
	private static final long serialVersionUID = 1L;

	public UsuarioNaoAutenticadoException(String mensagem) {
        super(mensagem);
    }
}
