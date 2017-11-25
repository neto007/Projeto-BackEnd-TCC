package com.chegaai.user;

import java.util.LinkedHashMap;

public class UserBasicData {
    private String nome;
    private String email;
    private String avatar;
    private String cidade;

    public UserBasicData(User user) {
        this.nome = user.getName();
        this.email = user.getEmail();
        this.avatar = user.getAvatar();
        this.cidade = user.getCidade();
    }

    public UserBasicData(LinkedHashMap<String, String> claim) {
        this.nome = claim.get("nome");
        this.email = claim.get("email");
        this.avatar = claim.get("avatar");
        this.cidade = claim.get("cidade");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
