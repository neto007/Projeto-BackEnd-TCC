package com.chegaai.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping("/cidade")
	private List<String> getCidadesComEstabelecimento() {
		return service.getCidadesComEstabelecimento();
	}
}
