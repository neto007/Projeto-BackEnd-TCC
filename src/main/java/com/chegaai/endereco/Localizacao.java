package com.chegaai.endereco;

import java.io.Serializable;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Localizacao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(nullable=true)
	@JsonProperty(required=false)
	private String latitude;
	
	@Column(nullable=true)
	@JsonProperty(required=false)
	private String longitude;
	
	public Localizacao() {
	}

	public Localizacao(String latitude, String longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}
}
