package com.chegaai.authentication;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Transactional
@Service("FacebookService")
public class FacebookService {

	public void sendNotification(String userId, String message){
		
		FacebookResponse facebookUser = AuthenticationContext.getFacebook().fetchObject(userId + "/notifications?template=" + message, FacebookResponse.class);
		
		if (facebookUser.getErro() == null) {
			throw new RuntimeException("Deu ruim, chama o Rafael");
		}
		
	}

}
