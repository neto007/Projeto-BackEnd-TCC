package com.chegaai.estabelecimento;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.commons.DefaultEntity;
import com.chegaai.endereco.Endereco;
import com.chegaai.estabelecimento.categoria.EstabelecimentoCategoria;
import com.chegaai.estabelecimento.comando.SalvarEstabelecimentoCommand;
import com.chegaai.estabelecimento.etiqueta.EstabelecimentoEtiqueta;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Estabelecimento implements DefaultEntity {
	
	@Id
	private String id;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String nome;
	
	@Column(nullable=true, columnDefinition="longblob")
	private String imagem;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String cnpj;
	
	@Column(nullable=false)
	@JsonProperty(required=true) 
	private String descricao;
	
	@ManyToOne
	private EstabelecimentoCategoria categoria; 
	
	@OneToOne
	private Endereco endereco;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String telefone;
	
	@Column(nullable=true)
	@JsonProperty(required=true)
	private String celular;
	
	@Column(name="dono_id")
	private String dono;
	
	@ManyToMany
	private List<EstabelecimentoEtiqueta> etiquetas;
	
	private Estabelecimento() {
		id = UUID.randomUUID().toString();
		dono = AuthenticationContext.getCurrentUserId();
	}

	public Estabelecimento(String nome, String imagem, String cnpj, String descricao, EstabelecimentoCategoria categoria,
			Endereco endereco, String telefone, String celular) {
		this();
		this.nome = nome;
		this.imagem = imagem;
		this.cnpj = cnpj;
		this.descricao = descricao;
		this.categoria = categoria;
		this.endereco = endereco;
		this.telefone = telefone;
		this.celular = celular;
	}

	public Estabelecimento(SalvarEstabelecimentoCommand comando) {
		this();
		setByComando(comando);
	}

	public void atualizar(SalvarEstabelecimentoCommand comando) {
		setByComando(comando);
	}
	
	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getImagem() {
		return imagem;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getDescricao() {
		return descricao;
	}

	public EstabelecimentoCategoria getCategoria() {
		return categoria;
	}

	public Endereco getEndereco() {
		return endereco;
	} 

	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
	}
	
	public String getDono() {
		return dono;
	}
	
	public List<EstabelecimentoEtiqueta> getEtiquetas() {
		return etiquetas;
	}

	private void setByComando(SalvarEstabelecimentoCommand comando) {
		this.nome = comando.getNome();
		this.imagem = comando.getImagem().getBase64();
		this.cnpj = comando.getCnpj();
		this.descricao = comando.getDescricao();
		this.telefone = comando.getTelefone();
		this.celular = comando.getCelular();				
		this.categoria = comando.getCategoria();
		this.endereco = comando.getEndereco();
		//this.etiquetas = comando.getEstabelecimentoEtiquetas();
	}
}
