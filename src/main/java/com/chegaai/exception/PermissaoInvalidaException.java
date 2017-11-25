package com.chegaai.exception;

public class PermissaoInvalidaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PermissaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}
