package com.chegaai.commons.erros;

abstract public class Erro {
	String message;
	String internalMessage;
	
	public Erro(String message, String internalMessage) {
		this.message = message;
		this.internalMessage = internalMessage;
	}
}
