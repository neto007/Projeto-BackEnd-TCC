package com.chegaai.estabelecimento.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.chegaai.commons.AbstractService;

@Service("EstabelecimentoCategoriaService")
public class EstabelecimentoCategoriaService extends AbstractService<EstabelecimentoCategoria, JpaRepository<EstabelecimentoCategoria,String>> {
	
}
