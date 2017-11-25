package com.chegaai.estabelecimento.etiqueta;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.chegaai.commons.DefaultEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="etiqueta")
public class EstabelecimentoEtiqueta implements DefaultEntity {

	@Id
	private String id;
	
	@Column(nullable=false)
	@JsonProperty(required=true)
	private String nome;
	
	public EstabelecimentoEtiqueta() {
		this.id = UUID.randomUUID().toString();
	}

	@Override
	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
}
