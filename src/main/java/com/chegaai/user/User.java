package com.chegaai.user;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.chegaai.authentication.FacebookTokenCredentials;
import com.chegaai.commons.DefaultEntity;
import com.chegaai.estabelecimento.categoria.EstabelecimentoCategoria;
import com.chegaai.estabelecimento.comando.VincularUsuarioComEstabelecimentoCommand;
import com.chegaai.user.comando.VincularUsuarioComEstabelecimentoCategoriaCommand;
import com.chegaai.user.permissao.UserPermissao;


@Entity
public class User implements DefaultEntity {
	@Id
	private String id;
	
	private String name;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	private String tipoUsuario;
	
	private String avatar;
	
	@Column(nullable=true)
	private String facebookToken;
	
	private String cidade;
	
	@ManyToMany
	private List<EstabelecimentoCategoria> interesse;

	@OneToMany(targetEntity = UserPermissao.class)
    @JoinColumn(name="user_id")
	private List<UserPermissao> permissoes;

	public User() {
		id = UUID.randomUUID().toString();
	}

	public User(String id, String name, String email, String password, String avatar, String cidade) {
		this();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = encryptPassword(password);
		this.cidade = cidade;
	}

	public User(String email) {
		this();
		this.email = email;
		this.tipoUsuario = TipoUsuario.PRE_CRIADO.getValor();
	}
	
	public User(org.springframework.social.facebook.api.User user, FacebookTokenCredentials credetials, String avatar) {
		this();
		this.email = user.getEmail();
		this.name = new StringBuilder(user.getFirstName()).append(" ").append(user.getLastName()).toString();
		this.facebookToken = credetials.getToken();
		this.avatar = avatar;
		this.tipoUsuario = TipoUsuario.COMUM.getValor();
	}

	public Boolean hasPermissaoToEstabelecimento(String nomePermissao, String idEstabelecimento) {
		return (permissoes.stream().filter(permissao -> permissao.getPermissao().equals(nomePermissao)).count() > 0);
	}

	private String encryptPassword(String passwordToEncrypt) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(passwordToEncrypt);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = encryptPassword(password);
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

    public void vincularComEstabelecimento(VincularUsuarioComEstabelecimentoCommand comando) {
        permissoes.addAll(comando.getUsuarioPermissoes());
    }
    
    public void vincularComInteresse(VincularUsuarioComEstabelecimentoCategoriaCommand comando) {
        interesse.addAll(comando.getCategorias());
    }

	public String getAvatar() {
		return avatar;
	}

	public String getFacebookToken() {
		return facebookToken;
	}
	
	public String getCidade() {
		return cidade;
	}
}
