package com.chegaai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class VoucherJaGeradoParaUsuarioException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VoucherJaGeradoParaUsuarioException(String msg){
		super(msg);
	}
}
