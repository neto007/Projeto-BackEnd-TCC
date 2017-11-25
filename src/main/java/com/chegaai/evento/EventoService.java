package com.chegaai.evento;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.commons.AbstractService;
import com.chegaai.endereco.Endereco;
import com.chegaai.endereco.EnderecoDTO;
import com.chegaai.endereco.EnderecoService;
import com.chegaai.estabelecimento.Estabelecimento;
import com.chegaai.estabelecimento.EstabelecimentoService;
import com.chegaai.evento.categoria.EventoCategoria;
import com.chegaai.evento.categoria.EventoCategoriaService;
import com.chegaai.evento.comando.SalvarEventoCommand;
import com.chegaai.exception.ConfirmacaoUsuarioException;
import com.chegaai.user.User;
import com.chegaai.voucher.Voucher;
import com.chegaai.voucher.VoucherService;

@Transactional
@Service("EventoService")
public class EventoService extends AbstractService<Evento, EventoRepository> {

	@Autowired
	private EventoCategoriaService categoriaService;
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private VoucherService voucherService;

	@Override
	public List<Evento> getAll() {
		return repository.findByDono(AuthenticationContext.getCurrentUserId());
	}

	public Evento criar(SalvarEventoCommand comando) {		
		EnderecoDTO enderecoVO = new EnderecoDTO(comando.getCep(),
				   comando.getRua(),
				   comando.getNumero(),
				   comando.getComplemento(),
				   comando.getBairro(),
				   comando.getCidade(),
				   comando.getEstado(),
				   comando.getLocalizacao());
		
		comando.setEndereco(criarEndereco(enderecoVO));
		comando.setEstabelecimento(getEstabelecimento(comando.getIdEstabelecimento()));
		comando.setCategoria(getCategoria(comando.getIdCategoria()));
		
		Evento evento = new Evento(comando);

		return super.salvar(evento);
	}
	
	public Evento atualizar(String id, SalvarEventoCommand comando) {		
		Evento evento = super.get(id);

		EnderecoDTO enderecoVO = new EnderecoDTO(comando.getCep(),
				   comando.getRua(),
				   comando.getNumero(),
				   comando.getComplemento(),
				   comando.getBairro(),
				   comando.getCidade(),
				   comando.getEstado(),
				   comando.getLocalizacao());		
		
		Endereco endereco = evento.getEndereco();
		endereco.setByEnderecoVO(enderecoVO);
		comando.setEndereco(endereco);
		comando.setCategoria(getCategoria(comando.getIdCategoria()));
		comando.setEstabelecimento(getEstabelecimento(comando.getIdEstabelecimento()));
		
		evento.atualizar(comando);
		
		return super.salvar(evento);
	}
	
	private Estabelecimento getEstabelecimento(String idEstabelecimento) {
		return estabelecimentoService.get(idEstabelecimento);
	}

	private EventoCategoria getCategoria(String idCategoria) {
		return categoriaService.get(idCategoria);
	} 

	private Endereco criarEndereco(EnderecoDTO enderecoVO) {
		return enderecoService.criar(enderecoVO);
	}

	public List<Evento> getEventoByEstabelecimento(String id) {
		return repository.findByEstabelecimentoId(id);
	}
	
	public List<Voucher> getVouchersByEvento(String id) {
		return voucherService.getByEvento(id);
	}

	public void confirmarPresenca(String id) {
		
		Evento evento = this.get(id);
		User currentUser = AuthenticationContext.getCurrentUser();
		
		if (evento.getUser().contains(currentUser)) {
			throw new ConfirmacaoUsuarioException("Usuário já confirmado.");
		} 
		
		evento.confirmarUsuario(currentUser);
		this.salvar(evento);
		
	}

	public void desconfirmarPresenca(String id) {
		Evento evento = this.get(id);
		User currentUser = AuthenticationContext.getCurrentUser();
		
		if (!evento.getUser().contains(currentUser)) {
			throw new ConfirmacaoUsuarioException("Usuário já desconfirmado.");
		} 
		
		evento.desconfirmarUsuario(currentUser);
		this.salvar(evento);
	}

	public void remover(String id) {
		voucherService.removerTodosPorEvento(id);
		super.remover(id);
	}

	public void removerTodosPorEstabelecimento(String id) {
		repository.removerTodosPorEstabelecimento(id);
	}

	public Long getPessoasConfirmadas(String id) {
		return repository.findPessoasConfirmadas(id);
	}

	public List<Evento> getEventos(String categoria, String data) {
		return repository.findByCategoriaIdAndData(categoria, data, AuthenticationContext.getCurrentUser().getCidade());
	}
}
