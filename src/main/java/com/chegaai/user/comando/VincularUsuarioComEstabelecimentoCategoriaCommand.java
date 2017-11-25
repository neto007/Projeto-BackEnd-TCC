package com.chegaai.user.comando;

import java.util.List;

import com.chegaai.estabelecimento.categoria.EstabelecimentoCategoria;

public class VincularUsuarioComEstabelecimentoCategoriaCommand {
	
	private List<String> interesses;
	
	private List<EstabelecimentoCategoria> categorias;
	
	public List<String> getInteresses() {
		return interesses;
	}

	public void setInteresses(List<String> interesses) {
		this.interesses = interesses;
	}

	public List<EstabelecimentoCategoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<EstabelecimentoCategoria> categorias) {
		this.categorias = categorias;
	}
	
}
