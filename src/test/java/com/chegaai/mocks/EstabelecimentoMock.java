package com.chegaai.mocks;

import static org.mockito.Mockito.mock;

import com.chegaai.estabelecimento.Estabelecimento;

public class EstabelecimentoMock {
	
	public Estabelecimento get() {
		Estabelecimento estabelecimento = mock(Estabelecimento.class);
		return estabelecimento;
	}
	
}
