package com.chegaai.voucherUsuario;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.commons.AbstractService;
import com.chegaai.exception.VoucherJaConfirmadoParaUsuarioException;
import com.chegaai.exception.VoucherJaGeradoParaUsuarioException;
import com.chegaai.voucher.Voucher;
import com.chegaai.voucher.VoucherService;
import com.chegaai.voucherUsuario.VoucherUsuario;
import com.chegaai.voucherUsuario.VoucherUsuarioRepository;

@Service("VoucherUsuarioService")
@Transactional
public class VoucherUsuarioService extends AbstractService<VoucherUsuario, VoucherUsuarioRepository> {	

	private static final String SIM = "S";
	
	@Autowired
	protected VoucherUsuarioRepository repository;
	
	@Autowired
	protected VoucherService voucherService;
	
	public void atualizaIndVoucherUtilizado(String idVoucher, String idUsuario) {
		repository.updateIndVoucherUtilizado(SIM, idVoucher, idUsuario);
	}
		
	public VoucherUsuario gerar(String id) {
		if(!AuthenticationContext.isUsuarioComum()) {
        	throw new AccessDeniedException("Você não pode fazer isso!");
        }
		
		validaSeVoucherJaGeradoParaUsuario(id, AuthenticationContext.getCurrentUserId());
		
		Voucher voucher = voucherService.get(id);
		
		VoucherUsuario voucherUsuario = new VoucherUsuario(voucher);
		
		return repository.save(voucherUsuario);
	} 
	
	public void confirmar(String id) {
		String idVoucher = id;
		String idUsuario = AuthenticationContext.getCurrentUserId();
		
		validaSeVoucherJaConfirmadoParaUsuario(idVoucher, idUsuario);
				
		repository.updateIndVoucherUtilizado(SIM, idVoucher, idUsuario);
	}

    private void validaSeVoucherJaGeradoParaUsuario(String idVoucher, String idUsuario) {
    	if(repository.findVoucherUsuario(idVoucher, idUsuario) != null) {
    		throw new VoucherJaGeradoParaUsuarioException("Esse voucher já foi gerado para esse usuário!");
    	}
    }
    
    private void validaSeVoucherJaConfirmadoParaUsuario(String idVoucher, String idUsuario) {
    	if(!repository.findVoucherConfirmadoUsuario(idVoucher, idUsuario).isEmpty()) {
    		throw new VoucherJaConfirmadoParaUsuarioException("Esse voucher já foi confirmado para esse usuário!");
    	}
    }
}
