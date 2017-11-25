package com.chegaai.endereco;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Endereco {
	
	@Id
	private String id;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String cep;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String rua;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String numero;
	
	@Column(nullable=true)
	@JsonProperty(required=true)
	private String complemento;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String bairro;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String estado;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String cidade;
	
	@Embedded
	private Localizacao localizacao;
	
	private Endereco() {
		id = UUID.randomUUID().toString();
	}
	
	public Endereco(EnderecoDTO enderecoVO) {
		this();
		setByEnderecoVO(enderecoVO);
	}

	public void setByEnderecoVO(EnderecoDTO enderecoDTO) {
		cep = enderecoDTO.getCep();
		rua = enderecoDTO.getRua();
		numero = enderecoDTO.getNumero();
		complemento = enderecoDTO.getComplemento();
		bairro = enderecoDTO.getBairro();
		cidade = enderecoDTO.getCidade();
		estado = enderecoDTO.getEstado();
		localizacao = enderecoDTO.getLocalizacao();
	}

	public void atualizar(EnderecoDTO enderecoVO) {
		setByEnderecoVO(enderecoVO);
	}

}
