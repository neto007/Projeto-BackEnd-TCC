package com.chegaai.estabelecimento.etiqueta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/estabelecimentoEtiqueta")
public class EstabelecimentoEtiquetaController {
	
	@Autowired
	private EstabelecimentoEtiquetaService service;
	
	@GetMapping()
	private List<EstabelecimentoEtiqueta> getEstabelecimentos() {
		return service.getAll();
	}
}
