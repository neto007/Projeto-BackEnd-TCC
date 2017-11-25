package com.chegaai.evento.comando;

import java.util.Date;

import com.chegaai.endereco.Endereco;
import com.chegaai.endereco.Localizacao;
import com.chegaai.estabelecimento.Estabelecimento;
import com.chegaai.estabelecimento.comando.ImageType;
import com.chegaai.evento.categoria.EventoCategoria;

public class SalvarEventoCommand {
	
	private String nome;
	
	private ImageType imagem;
	
	private String descricao;
	
	private Date data;
	
	private String idCategoria;
	
	private String idEstabelecimento;
	
	private String telefone;
	
	private String celular;
	
	private String cep;
	
	private String rua;
	
	private String numero;
	
	private String bairro;
	
	private String complemento;
	
	private String estado;
	
	private String cidade;
	
	private Localizacao localizacao;
	
	private Endereco endereco;

	private EventoCategoria categoria;
	
	private Estabelecimento estabelecimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public String getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(String idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public EventoCategoria getCategoria() {
		return categoria;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setCategoria(EventoCategoria categoria) {
		this.categoria = categoria;
	}

	public ImageType getImagem() {
		return imagem;
	}

	public void setImagem(ImageType imagem) {
		this.imagem = imagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

}
