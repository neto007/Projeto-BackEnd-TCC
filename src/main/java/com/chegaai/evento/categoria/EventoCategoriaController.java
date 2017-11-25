package com.chegaai.evento.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventoCategoria")
public class EventoCategoriaController {
	
	@Autowired
	private EventoCategoriaService service; 
	
	@GetMapping()
	private List<EventoCategoria> getEvento() {
		return service.getAll();
	}

}
