package com.chegaai.authentication;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.chegaai.user.User;
import com.chegaai.user.UserBasicData;
import com.chegaai.user.UserRepository;

import io.jsonwebtoken.SignatureException;

@Service("AuthenticationService")
public class AuthenticationService {
	@Autowired
	private UserRepository userRepo;

    public Authentication getAuthentication(HttpServletRequest request) {
		String AuthorizationHeader = request.getHeader("Authorization");
		Token token;

		
		if(AuthorizationHeader == null) {
			return null;
		}
		
		try {
			token = Token.factoryByString(AuthorizationHeader.replace("Bearer", ""));
		} catch(SignatureException exception) {
			return null;
		}

		return new UsernamePasswordAuthenticationToken(
				token,
				null,
				new ArrayList<>()
		);
	}

	public Token createAuthenticationToken(String userEmail) {
		User user = userRepo.findByEmail(userEmail);
		return Token.factoryBySubject(user.getId(), new UserBasicData(user));
	}

	public Token getTokenByFacebook(org.springframework.social.facebook.api.User facebookUser,
			FacebookTokenCredentials credetials) {
		User user = userRepo.findByEmail(facebookUser.getEmail());
		
		if(user == null) {
			String avatar = "http://graph.facebook.com/" + facebookUser.getId() + "/picture?type=square";
			user = new User(facebookUser, credetials, avatar);
			userRepo.save(user);
		}
		
		return Token.factoryBySubject(user.getId(), new UserBasicData(user));
		
	}
}
