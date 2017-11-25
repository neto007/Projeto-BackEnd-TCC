package com.chegaai.evento.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.chegaai.commons.AbstractService;

@Service("EventoCategoriaService")
public class EventoCategoriaService extends AbstractService<EventoCategoria, JpaRepository<EventoCategoria,String>> {
	
}
