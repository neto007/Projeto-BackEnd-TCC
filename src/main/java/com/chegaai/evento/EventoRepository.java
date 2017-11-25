package com.chegaai.evento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EventoRepository extends JpaRepository<Evento, String> {
	
//	@Query(value = "select ev.*, count(uc.evento_id) > 0 as evento_confirmado "
//			+ "from evento ev inner join evento_usuarios_confirmados uc "
//			+ "on uc.evento_id = ?1 and "
//			+ "uc.usuarios_confirmados_id = ?2 "
//			+ "where ev.id = ?1" , nativeQuery = true)
//	Evento findOne(String id, String userId);

	List<Evento> findByEstabelecimentoId(String id);

    @Modifying
    @Query("delete from Evento ev where ev.estabelecimento.id = ?1")
    void removerTodosPorEstabelecimento(String id);
    
    @Query(value="select count(e.evento_id) from evento_usuarios_confirmados e where e.evento_id = ?1", nativeQuery=true)
	Long findPessoasConfirmadas(String id);

	@Query(value="SELECT ev.* FROM evento ev "
			+ "INNER JOIN estabelecimento es ON ev.estabelecimento_id = es.id "
			+ "WHERE es.dono_id = ?1 or "
			+ "EXISTS (select up.id from user_permissao up "
					+ "where up.user_id = ?1)", nativeQuery=true)
	List<Evento> findByDono(String donoId);
	
	@Query(value = "select ev.* from evento ev INNER JOIN endereco end ON ev.endereco_id = end.id where ev.categoria_id = coalesce(?1, ev.categoria_id, ?1) and ev.data = coalesce(?2, ev.data, ?2) and end.cidade = ?3", nativeQuery=true)
	List<Evento> findByCategoriaIdAndData(String categoria, String data, String cidade);
}
