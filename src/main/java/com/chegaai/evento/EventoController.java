package com.chegaai.evento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.evento.comando.SalvarEventoCommand;
import com.chegaai.utils.ResponseUtils;
import com.chegaai.voucher.Voucher;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoService service;
		
	@GetMapping("/{id}")
	private Evento getEvento(@PathVariable String id) {
		return service.get(id);
	}

	@GetMapping("/{id}/voucher")
	private List<Voucher> getVouchersByEvento(@PathVariable String id) {
		return service.getVouchersByEvento(id);
	}
	
	@GetMapping("/{id}/pessoasConfirmadas")
	private Long getPessoasConfirmadas(@PathVariable String id) {
		return service.getPessoasConfirmadas(id);
	}
	
	@PostMapping
	private ResponseEntity<Object> addEvento(@RequestBody SalvarEventoCommand comando) {
		if (!AuthenticationContext.isUsuarioAdmin()) {
			throw new AccessDeniedException("Você não pode fazer isso.");
		}
		
		Evento evento = service.criar(comando);
		return ResponseUtils.created(evento);
	}
	
	@PostMapping("/{id}")
	private ResponseEntity<Object> updateEstabelecimento(@PathVariable String id, @RequestBody SalvarEventoCommand comando) {
		if (!AuthenticationContext.isUsuarioAdmin()) {
			throw new AccessDeniedException("Você não pode fazer isso.");
		}
		
		Evento evento = service.atualizar(id, comando);
		return ResponseUtils.updated(evento);
	}
	
	@PostMapping("/{id}/confirmarPresenca")
	private ResponseEntity<Object> confirmarPresenca(@PathVariable String id){
		if (!AuthenticationContext.isUsuarioComum()) {
			throw new AccessDeniedException("Você não pode fazer isso.");
		}
		
		service.confirmarPresenca(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/{id}/desconfirmarPresenca")
	private ResponseEntity<Object> desconfirmarPresenca(@PathVariable String id){
		if (!AuthenticationContext.isUsuarioComum()) {
			throw new AccessDeniedException("Você não pode fazer isso.");
		}
		
		service.desconfirmarPresenca(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Object> deletarEvento(@PathVariable String id) {
		service.remover(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping()
	private List<Evento> getEventos(@RequestParam(value="categoria", required=false) String categoria,
									@RequestParam(value="data", required=false) String data) {
		if (!AuthenticationContext.isUsuarioComum()) {
			return service.getAll();
		}
		
		return service.getEventos(categoria, data);
	}
}
