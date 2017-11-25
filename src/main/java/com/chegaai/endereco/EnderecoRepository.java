package com.chegaai.endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {

	@Query(value = "select distinct cidade from endereco", nativeQuery = true)
	List<String> findCidadesComEstabelecimento();	
}
