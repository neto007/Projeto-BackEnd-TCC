package com.chegaai.authentication;

import java.io.Serializable;

public class FacebookResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String sucesso;
	
	private String erro;

	public String getSucesso() {
		return sucesso;
	}

	public void setSucesso(String sucesso) {
		this.sucesso = sucesso;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
	
}
