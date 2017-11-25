package com.chegaai.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chegaai.user.comando.AtualizarCidadeUsuarioCommand;
import com.chegaai.user.comando.VincularUsuarioComEstabelecimentoCategoriaCommand;
import com.chegaai.utils.ResponseUtils;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService service;
	
	@GetMapping
	private List<User> getUsers() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	private User getUser(@PathVariable String id) {
		return service.get(id);
	}
	
	@PostMapping
	private ResponseEntity<Object> postUser(@RequestBody User user) {		
		service.salvar(user);
		return ResponseUtils.created(user);
	}
	
	@PostMapping("/interesse")
	private ResponseEntity<Object> vincularInteresses(@RequestBody VincularUsuarioComEstabelecimentoCategoriaCommand comando) {		
		service.vincularComInteresse(comando);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/cidade")
	private ResponseEntity<Object> updateCidade(@RequestBody AtualizarCidadeUsuarioCommand cidade) {	
		service.atualizarCidade(cidade);
		return ResponseEntity.ok().build();
	}
}
