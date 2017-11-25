package com.chegaai.voucher;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.*;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.commons.DefaultEntity;
import com.chegaai.estabelecimento.Estabelecimento;
import com.chegaai.evento.Evento;
import com.chegaai.voucher.comando.SalvarVoucherCommand;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Voucher implements DefaultEntity {
	
	@Id
	private String id;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String nome;
	
	@Column(nullable=true)
	@JsonProperty(required=false)
	private Date dataInicial;
	
	@Column(nullable=true)
	@JsonProperty(required=false)
	private Date dataFinal;
	
	@Column(nullable=true)
	@JsonProperty(required=false)
	private int quantidade;
	
	@Column(name="criador")
	private String criador;
	
	@Column(columnDefinition="longblob")
	private String imagem;
	
	@ManyToOne
	private Estabelecimento estabelecimento;
	
	@ManyToOne
	private Evento evento;
		
	private Voucher() {
		id = UUID.randomUUID().toString();
		criador = AuthenticationContext.getCurrentUserId();
	}

	public Voucher(String nome, Date dataInicial, Date dataFinal, int quantidade, 
			       Estabelecimento estabelecimento, Evento evento) {
		this();
		this.nome = nome;		
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.quantidade = quantidade;
		this.estabelecimento = estabelecimento;
		this.evento = evento;
	}

	public Voucher(SalvarVoucherCommand comando) {
		this();
		setByComando(comando);
	}

	public void atualizar(SalvarVoucherCommand comando) {
		setByComando(comando);
	}
	
	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Date getDataInicial() {
		return dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public String getCriador() {
		return criador;
	}
	
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	
	public Evento getEvento() {
		return evento;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	private void setByComando(SalvarVoucherCommand comando) {
		this.nome = comando.getNome();
		this.dataInicial = comando.getDataInicial();
		this.dataFinal = comando.getDataFinal();
		this.quantidade = comando.getQuantidade();
		this.estabelecimento = comando.getEstabelecimento();
		this.evento = comando.getEvento();
		this.imagem = comando.getImagem().getBase64();
	}
}
