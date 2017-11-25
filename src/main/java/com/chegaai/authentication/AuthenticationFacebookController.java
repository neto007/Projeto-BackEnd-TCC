package com.chegaai.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationFacebookController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/facebook")
	private Token login(@RequestBody FacebookTokenCredentials credetials) {
		Facebook facebook = new FacebookTemplate(credetials.getToken());
		String [] fields = { "id", "email", "first_name", "last_name" };
		User user = facebook.fetchObject("me", User.class, fields);
		
		Token token = authenticationService.getTokenByFacebook(user, credetials);
		
		return token;
	}
}
