package com.chegaai.estabelecimento.comando;

import java.util.List;

import com.chegaai.endereco.Endereco;
import com.chegaai.endereco.Localizacao;
import com.chegaai.estabelecimento.categoria.EstabelecimentoCategoria;
import com.chegaai.estabelecimento.etiqueta.EstabelecimentoEtiqueta;

public class SalvarEstabelecimentoCommand {
	
	private String nome;
	
	private ImageType imagem;
	
	private String cnpj;
	
	private String descricao;
	
	private String idCategoria;
	
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

	private EstabelecimentoCategoria categoria;
	
	private List<String> etiquetas;
	
	private List<EstabelecimentoEtiqueta> estabelecimentoEtiquetas;

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public ImageType getImagem() {
		return imagem;
	}

	public void setImagem(ImageType imagem) {
		this.imagem = imagem;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public EstabelecimentoCategoria getCategoria() {
		return categoria;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setCategoria(EstabelecimentoCategoria categoria) {
		this.categoria = categoria;
	}

	public List<String> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<String> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public List<EstabelecimentoEtiqueta> getEstabelecimentoEtiquetas() {
		return estabelecimentoEtiquetas;
	}

	public void setEstabelecimentoEtiquetas(List<EstabelecimentoEtiqueta> estabelecimentoEtiquetas) {
		this.estabelecimentoEtiquetas = estabelecimentoEtiquetas;
	}
	
}
