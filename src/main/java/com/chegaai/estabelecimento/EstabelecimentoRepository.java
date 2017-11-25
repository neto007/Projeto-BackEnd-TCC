package com.chegaai.estabelecimento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, String> {

	List<Estabelecimento> findByDono(String donoId);

	List<Estabelecimento> findByEnderecoCidade(String cidade);

}
