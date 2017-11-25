package com.chegaai.voucher;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface VoucherRepository extends JpaRepository<Voucher, String> {
	
	@Query(value = "select v.* from voucher v where v.estabelecimento_id = ?1 and (select vu.voucher_id from voucher_usuario)", nativeQuery = true)
	public List<Voucher> findByEstabelecimentoId(String id);
	
	@Query(value = "select v.* from voucher v where v.evento_id = ?1 and v.id not in (select vu.voucher_id from voucher_usuario vu where v.id = vu.voucher_id and usuario_id = ?2)", nativeQuery = true)
	public List<Voucher> findByEventoId(String id, String userId);

	@Query(value = "select v.* from voucher v inner join voucher_usuario vu on v.id = vu.voucher_id where vu.ind_utilizado = 'N' and vu.usuario_id = ?1", nativeQuery = true)
	public List<Voucher> findByUsuario(String id);

	@Modifying
	@Query("delete from Voucher v where v.evento.id = ?1")
    void removerTodosPorEvento(String id);

	@Modifying
	@Query("delete from Voucher v where v.estabelecimento.id = ?1")
	void removerTodosPorEstabelecimento(String id);
}
