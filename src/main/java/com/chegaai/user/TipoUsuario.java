package com.chegaai.user;

public enum TipoUsuario {
	ADMIN("admin"),
	COMUM("comum"),
	PRE_CRIADO("pre_criado");

    private String valor;
	
	TipoUsuario(String key) {
		valor = key;
	}
	
	public String getValor() {
		return valor;
	}
}
