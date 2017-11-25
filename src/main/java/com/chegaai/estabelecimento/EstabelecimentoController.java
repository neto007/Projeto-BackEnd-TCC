package com.chegaai.estabelecimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.authentication.OnlyUsarioAdmin;
import com.chegaai.estabelecimento.comando.SalvarEstabelecimentoCommand;
import com.chegaai.estabelecimento.comando.VincularUsuarioComEstabelecimentoCommand;
import com.chegaai.evento.Evento;
import com.chegaai.user.permissao.Permissao;
import com.chegaai.utils.PermissionUtils;
import com.chegaai.utils.ResponseUtils;
import com.chegaai.voucher.Voucher;

@Controller
@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoService service;
	
	@GetMapping()
	private List<Estabelecimento> getEstabelecimentos() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	private Estabelecimento getEstabelecimento(@PathVariable String id) {
		return service.get(id);
	}
	
	@GetMapping("/{id}/evento")
	private List<Evento> getEventoByEstabelecimento(@PathVariable String id) {
		return service.getEventoByEstabelecimento(id);
	}

	@PostMapping
	private ResponseEntity<Object> addEstabelecimento(@RequestBody SalvarEstabelecimentoCommand comando) {
	
		
		if(!AuthenticationContext.isUsuarioAdmin()) {
			throw new AccessDeniedException("Você nao pode fazer isso.");
		}

        Estabelecimento estabelecimento = service.criar(comando);
		return ResponseUtils.created(estabelecimento);
	}
	
	@PostMapping("/{id}")
	@OnlyUsarioAdmin
	private ResponseEntity<Object> updateEstabelecimento(@PathVariable String id, @RequestBody SalvarEstabelecimentoCommand comando) {
		if(!AuthenticationContext.isUsuarioAdmin()) {
			throw new AccessDeniedException("Você nao pode fazer isso.");
		}

		PermissionUtils.verificaPermissao(Permissao.ATUALIZAR_ESTABELECIMENTO, id);

		Estabelecimento estabelecimento = service.atualizar(id, comando);
		return ResponseUtils.updated(estabelecimento);
	}

	@GetMapping("/{id}/voucher")
	private List<Voucher> getVouchersByEstabelecimento(@PathVariable String id) {
		return service.getVouchersByEstabelecimento(id);
	}

	@PostMapping("/{id}/usuario")
	private ResponseEntity<Object> vincularUsuarioComEstabelecimento(@PathVariable String id, @RequestBody VincularUsuarioComEstabelecimentoCommand comando) {
		service.vincularUsuario(id, comando);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
    private ResponseEntity<Object> deletarEstabelecimento(@PathVariable String id) {
	    service.remover(id);
	    return ResponseEntity.ok().build();
    }
}
