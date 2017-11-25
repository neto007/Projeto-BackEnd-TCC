package com.chegaai.voucher;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.commons.AbstractService;
import com.chegaai.estabelecimento.Estabelecimento;
import com.chegaai.estabelecimento.EstabelecimentoService;
import com.chegaai.evento.Evento;
import com.chegaai.evento.EventoService;
import com.chegaai.voucher.comando.SalvarVoucherCommand;

@Service("VoucherService")
@Transactional
public class VoucherService extends AbstractService<Voucher, VoucherRepository> {	


	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	protected VoucherRepository repository;
	
	@Override
	public List<Voucher> getAll() {
		if(AuthenticationContext.isUsuarioAdmin()) {
			return getAllToAdmin();
		}

		return getAllToUsuarioComum();
	}

    private List<Voucher> getAllToAdmin() {
    	return super.getAll();
    }

    private List<Voucher> getAllToUsuarioComum() {
	    return repository.findByUsuario(AuthenticationContext.getCurrentUserId());
    }
    
    public Voucher criar(SalvarVoucherCommand comando) {
		if(AuthenticationContext.isUsuarioComum()) {
		    throw new AccessDeniedException("Você não pode fazer isso!");
        }
		
		Estabelecimento estabelecimento = estabelecimentoService.get(comando.getIdEstabelecimento());
		
		comando.setEstabelecimento(estabelecimento);
		
		Evento evento = eventoService.get(comando.getIdEvento());
		
		comando.setEvento(evento);
		
		Voucher voucher = new Voucher(comando);

		return super.salvar(voucher);
	}
    
    public Voucher atualizar(String id, SalvarVoucherCommand comando) {	
    	if(AuthenticationContext.isUsuarioComum()) {
		    throw new AccessDeniedException("Você não pode fazer isso!");
        }
    	
    	Estabelecimento estabelecimento = estabelecimentoService.get(comando.getIdEstabelecimento());
    	
    	comando.setEstabelecimento(estabelecimento);
    	
    	Evento evento = eventoService.get(comando.getIdEvento());
		
		comando.setEvento(evento);
    	
    	Voucher voucher = super.get(id);

		voucher.atualizar(comando);
		
		return super.salvar(voucher);
	}

	public List<Voucher> getByEstabelecimento(String id) {
		return repository.findByEstabelecimentoId(id);
	}
	
	public List<Voucher> getByEvento(String id) {
		return repository.findByEventoId(id, AuthenticationContext.getCurrentUserId());
	}

    public void removerTodosPorEvento(String id) {
		repository.removerTodosPorEvento(id);
    }

	public void removerTodosPorEstabeleciemto(String id) {
		repository.removerTodosPorEstabelecimento(id);
	}
}
