package com.chegaai.commons.erros;

public class ErroInesperado extends Erro {

	private static final String DEFAULT_MESSAGE = "Ocorreu um erro inesperado, tente novamente mais tarde.";

	public ErroInesperado(String internalMessage) {
		super(DEFAULT_MESSAGE, internalMessage);
	}
	
}
