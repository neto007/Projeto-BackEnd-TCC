package com.chegaai.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chegaai.commons.AbstractService;

@Service("EnderecoService")
public class EnderecoService extends AbstractService<Endereco, EnderecoRepository> {

	@Autowired
	EnderecoRepository repository;
	
	public Endereco criar(EnderecoDTO enderecoDTO) {
		Endereco estabelecimentoEndereco = new Endereco(enderecoDTO);
		return salvar(estabelecimentoEndereco);
	}

	public List<String> getCidadesComEstabelecimento() {
		return repository.findCidadesComEstabelecimento();
	}
}
