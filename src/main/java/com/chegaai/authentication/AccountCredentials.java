package com.chegaai.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountCredentials {
	private String username;
	private String password;

	@JsonCreator
	public AccountCredentials(
			@JsonProperty("username") String username, 
			@JsonProperty("password") String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
