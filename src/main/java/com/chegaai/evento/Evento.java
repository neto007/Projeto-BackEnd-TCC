package com.chegaai.evento;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.commons.DefaultEntity;
import com.chegaai.endereco.Endereco;
import com.chegaai.estabelecimento.Estabelecimento;
import com.chegaai.evento.categoria.EventoCategoria;
import com.chegaai.evento.comando.SalvarEventoCommand;
import com.chegaai.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Evento implements DefaultEntity {
	
	@Id	
	private String id;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String nome;
	
	@Column(nullable=true, columnDefinition="longblob") 
	@JsonProperty(required=true)
	private String imagem;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String descricao;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	@OrderBy("DESC")
	private Date data;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String telefone;
	
	@Column(nullable=true)
	@JsonProperty(required=true)
	private String celular;
	
	@Column(name="criador")
	private String criador;
	
	@ManyToOne
	private EventoCategoria categoria;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	private Endereco endereco;
	
	@ManyToOne
	private Estabelecimento estabelecimento; 
	
	@ManyToMany
	private List<User> usuariosConfirmados; 

//	@Transient
//	private Integer eventoConfirmado;
	
	private Evento() {
		id = UUID.randomUUID().toString();
		criador = AuthenticationContext.getCurrentUserId();
	}

	public Evento(String nome, String imagem, String descricao, Date data, String telefone, String celular,
			EventoCategoria categoria, Endereco endereco, Estabelecimento estabelecimento) {
		this();
		this.nome = nome;
		this.imagem = imagem;
		this.descricao = descricao;
		this.categoria = categoria;
		this.data = data;
		this.telefone = telefone;
		this.celular = celular;
		this.endereco = endereco;
		this.estabelecimento = estabelecimento;
	}

	public Evento(SalvarEventoCommand comando) {
		this();
		setByComando(comando);
	}

	public void atualizar(SalvarEventoCommand comando) {
		setByComando(comando);
	}
	
	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public EventoCategoria getCategoria() {
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
	
	public String getImagem() {
		return imagem;
	}

	public Date getData() {
		return data;
	}

	public String getCriador() {
		return criador;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public List<User> getUser() {
		return usuariosConfirmados;
	}

	private void setByComando(SalvarEventoCommand comando) {
		this.nome = comando.getNome();
		this.descricao = comando.getDescricao();
		this.imagem = comando.getImagem().getBase64();
		this.data = comando.getData();
		this.estabelecimento = comando.getEstabelecimento();
		this.telefone = comando.getTelefone();
		this.celular = comando.getCelular();				
		this.categoria = comando.getCategoria();
		this.endereco = comando.getEndereco();
	}

	public void confirmarUsuario(User currentUser) {
		usuariosConfirmados.add(currentUser);
	}

	public void desconfirmarUsuario(User currentUser) {
		usuariosConfirmados.remove(currentUser);
	}

//	public Integer getEventoConfirmado() {
//		return eventoConfirmado;
//	}
}
