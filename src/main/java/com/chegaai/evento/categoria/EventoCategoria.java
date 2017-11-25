package com.chegaai.evento.categoria;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evento_categoria")
public class EventoCategoria {
	@Id
	private String id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String imagem;
	
	public EventoCategoria() {
		this.id = UUID.randomUUID().toString();
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
}
