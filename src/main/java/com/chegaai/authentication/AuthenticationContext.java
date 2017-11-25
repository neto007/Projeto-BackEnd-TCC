package com.chegaai.authentication;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Component;

import com.chegaai.exception.UsuarioNaoAutenticadoException;
import com.chegaai.user.TipoUsuario;
import com.chegaai.user.User;
import com.chegaai.user.UserService;
import com.chegaai.utils.RequestUtils;

@Component
public class AuthenticationContext {
	
    private static UserService userService;

    @Autowired
    private UserService tUserService;

    @PostConstruct
    public void init() {
        AuthenticationContext.userService = tUserService;
    }
	
	public static User getCurrentUser() {
        User usuario = (User) RequestUtils.getRequestAttribute(RequestUtils.CURRENT_USER);

        if(usuario == null) {
            usuario = userService.get(getCurrentUserId());

            if(usuario == null) {
                throw new UsuarioNaoAutenticadoException("Você não tem permissão para isso.");
            }

            RequestUtils.setRequestAttribute(RequestUtils.CURRENT_USER, usuario);
        }

        return usuario;
	}
	
	public static Facebook getFacebook() {
		User user = getCurrentUser();
		
		return new FacebookTemplate(user.getFacebookToken());

	}
	
	public static org.springframework.social.facebook.api.User getFacebookUser() {
		
		org.springframework.social.facebook.api.User usuario = (org.springframework.social.facebook.api.User) RequestUtils.getRequestAttribute(RequestUtils.FACEBOOK_USER);
		
		if (usuario == null) {
			String [] fields = { "id", "email", "first_name", "last_name" };
			usuario = getFacebook().fetchObject("me", org.springframework.social.facebook.api.User.class, fields);
			
			RequestUtils.setRequestAttribute(RequestUtils.FACEBOOK_USER, usuario);
		}
		
		return usuario;
	}

	public static String getCurrentUserId() {
		return ((Token) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getSubject();
	}
	
	public static Boolean isUsuarioComum() {
		return TipoUsuario.COMUM.getValor().equals(getCurrentUser().getTipoUsuario());
	}
	
	public static Boolean isUsuarioAdmin() {
		return TipoUsuario.ADMIN.getValor().equals(getCurrentUser().getTipoUsuario());
	}

}
