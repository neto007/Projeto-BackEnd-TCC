package com.chegaai.voucherUsuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface VoucherUsuarioRepository extends JpaRepository<VoucherUsuario, String> {
	
	@Query(value = "select id from voucher_usuario where voucher_id = ?1 and usuario_id = ?2", nativeQuery = true)
	String findVoucherUsuario(String idVoucher, String idUsuario);

	@Query(value = "select id from voucher_usuario where voucher_id = ?1 and usuario_id = ?2 and ind_utilizado = 'S'", nativeQuery = true)
	List<String> findVoucherConfirmadoUsuario(String idVoucher, String idUsuario);
	
	@Modifying
	@Query(value = "update voucher_usuario set ind_utilizado = ?1 where voucher_id = ?2 and usuario_id = ?3", nativeQuery = true)
	int updateIndVoucherUtilizado(String indUtilizado, String idVoucher, String idUsuario);
}
