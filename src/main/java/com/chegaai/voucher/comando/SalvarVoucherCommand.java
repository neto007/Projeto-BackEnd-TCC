package com.chegaai.voucher.comando;

import java.sql.Date;

import com.chegaai.estabelecimento.Estabelecimento;
import com.chegaai.estabelecimento.comando.ImageType;
import com.chegaai.evento.Evento;

public class SalvarVoucherCommand {
	
	private String nome;
	
	private Date dataInicial;
	
	private Date dataFinal;
	
	private int quantidade;
	
	private String idEstabelecimento;
	
	private Estabelecimento estabelecimento;
	
	private Evento evento;
	
	private String idEvento;
	
	private ImageType imagem;

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
	
	public String getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Evento getEvento() {
		return evento;
	}
	
	public String getIdEvento() {
		return idEvento;
	}
	
	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public ImageType getImagem() {
		return imagem;
	}
}
