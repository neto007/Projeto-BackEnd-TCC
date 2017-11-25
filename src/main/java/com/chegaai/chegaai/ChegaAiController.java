package com.chegaai.chegaai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chegaai.authentication.AuthenticationContext;

@Controller
@RestController
@RequestMapping("/chegaai")
public class ChegaAiController {
	
	@Autowired
	private ChegaAiService service;
	
	@GetMapping()
	private List<UsuarioFacebookVO> getAmigos() {
		if(AuthenticationContext.isUsuarioAdmin()) {
			throw new AccessDeniedException("Você nao pode fazer isso.");
		}
		return service.getAll();
	}
	
	@PostMapping()
	private ResponseEntity<Object> inviteAmigos(@RequestBody InviteAmigosCommand comando) {
		if(AuthenticationContext.isUsuarioAdmin()) {
			throw new AccessDeniedException("Você nao pode fazer isso.");
		}

        service.convidar(comando);
		return ResponseEntity.ok().build();
	}
}
