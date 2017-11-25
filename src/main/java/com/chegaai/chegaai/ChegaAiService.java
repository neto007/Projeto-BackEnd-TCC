package com.chegaai.chegaai;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.UserTaggableFriend;
import org.springframework.stereotype.Service;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.authentication.FacebookService;

@Transactional
@Service("ChegaAiService")
public class ChegaAiService {
	
	@Autowired
	private FacebookService facebookService;
	
	private UsuarioFacebookVO criarUsuarioFacebook(UserTaggableFriend user) {
		
		UsuarioFacebookVO usuarioFacebook = new UsuarioFacebookVO();
		
		usuarioFacebook.setId(user.getId());
		usuarioFacebook.setNome(user.getName());
		usuarioFacebook.setAvatar(user.getPicture().getUrl());
		
		return usuarioFacebook;
	}
	
	public List<UsuarioFacebookVO> getAll() {
		
		List<UserTaggableFriend> friendLists = AuthenticationContext.getFacebook().fetchConnections("me", "taggable_friends?limit=5000", UserTaggableFriend.class, "id", "name" ,"picture", "first_name", "last_name", "middle_name");
		
		List<UsuarioFacebookVO> amigos = new ArrayList<UsuarioFacebookVO>();
		
		for (UserTaggableFriend user : friendLists) {
			amigos.add(criarUsuarioFacebook(user));
			
		}
		
		return amigos;
	}

	public void convidar(InviteAmigosCommand comando) {
		
		org.springframework.social.facebook.api.User facebookUser = AuthenticationContext.getFacebookUser();
		
		String message = "@{" + facebookUser.getId() + "}" + " está te chamando para se encontrar com ele. Chega Aí!!!";
		
		for (String amigo : comando.getAmigos()) {
			
			try {
				facebookService.sendNotification(amigo, message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
