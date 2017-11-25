package com.chegaai.voucher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.chegaai.utils.ResponseUtils;
import com.chegaai.voucher.comando.SalvarVoucherCommand;
import com.chegaai.voucherUsuario.VoucherUsuario;
import com.chegaai.voucherUsuario.VoucherUsuarioService;

@Controller
@RestController
@RequestMapping("/voucher")
public class VoucherController {
	
	@Autowired
	private VoucherService service;
	
	@Autowired
	private VoucherUsuarioService voucherUsuarioService;
	
	@GetMapping()
	private List<Voucher> getVouchers() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	private Voucher getVouchers(@PathVariable String id) {
		return service.get(id);
	}
	
	@PostMapping
	private ResponseEntity<Object> addVoucher(@RequestBody SalvarVoucherCommand comando) {
		Voucher voucher = service.criar(comando);
		return ResponseUtils.created(voucher);
	}
	
	@PostMapping("/{id}")
	private ResponseEntity<Object> updateVoucher(@PathVariable String id, @RequestBody SalvarVoucherCommand comando) {
		Voucher voucher = service.atualizar(id, comando);
		return ResponseUtils.updated(voucher);
	}
	
	@PostMapping("/{id}/gerar")
	private ResponseEntity<Object> gerarVoucher(@PathVariable String id) {
		VoucherUsuario voucherUsuario = voucherUsuarioService.gerar(id);
		return ResponseUtils.created(voucherUsuario);
	}
	
	@PostMapping("/{id}/confirmar")
	private ResponseEntity<Object> confirmarVoucher(@PathVariable String id) {
		voucherUsuarioService.confirmar(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Object> deletarVoucher(@PathVariable String id) {
		service.remover(id);
		return ResponseEntity.ok().build();
	}
}
