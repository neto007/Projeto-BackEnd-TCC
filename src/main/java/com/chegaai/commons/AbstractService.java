package com.chegaai.commons;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<Entity, Repository extends JpaRepository<Entity,String>> {
	@Autowired
	protected Repository repository;
	
	public List<Entity> getAll() {
		return (List<Entity>) repository.findAll();
	}
	
	public Entity get(String id) {
		return repository.findOne(id);
	}
	
	public Entity salvar(Entity entity) {
		return repository.save(entity);
	}

    public void remover(String id) {
        repository.delete(id);
	};
}
