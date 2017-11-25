package com.chegaai.estabelecimento;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.commons.AbstractService;
import com.chegaai.endereco.Endereco;
import com.chegaai.endereco.EnderecoDTO;
import com.chegaai.endereco.EnderecoService;
import com.chegaai.estabelecimento.categoria.EstabelecimentoCategoria;
import com.chegaai.estabelecimento.categoria.EstabelecimentoCategoriaService;
import com.chegaai.estabelecimento.comando.SalvarEstabelecimentoCommand;
import com.chegaai.estabelecimento.comando.VincularUsuarioComEstabelecimentoCommand;
import com.chegaai.evento.Evento;
import com.chegaai.evento.EventoService;
import com.chegaai.user.User;
import com.chegaai.user.UserService;
import com.chegaai.voucher.Voucher;
import com.chegaai.voucher.VoucherService;

@Transactional
@Service("EstabelecimentoService")
public class EstabelecimentoService extends AbstractService<Estabelecimento, EstabelecimentoRepository> {

	@Autowired
	private EstabelecimentoCategoriaService categoriaService;
	
	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private EventoService eventoService;

	@Autowired
	private VoucherService voucherService;

    @Autowired
    private UserService userService;
    
	@Override
	public List<Estabelecimento> getAll() {
		if(AuthenticationContext.isUsuarioAdmin()) {
			return getAllToAdmin();
		}

		return getAllToUsuarioComum();
	}

    private List<Estabelecimento> getAllToAdmin() {
        return repository.findByDono(AuthenticationContext.getCurrentUserId());
    }

    public Estabelecimento criar(SalvarEstabelecimentoCommand comando) {
		if(AuthenticationContext.isUsuarioComum()) {
		    throw new AccessDeniedException("Você não pode fazer isso.");
        }

		EnderecoDTO enderecoDTO = new EnderecoDTO(comando.getCep(),
				   comando.getRua(),
				   comando.getNumero(),
				   comando.getComplemento(),
				   comando.getBairro(),
				   comando.getCidade(),
				   comando.getEstado(),
				   comando.getLocalizacao());
		
		comando.setEndereco(criarEndereco(enderecoDTO));
		
		comando.setCategoria(getCategoria(comando.getIdCategoria()));
		
		//comando.setEstabelecimentoEtiquetas(vincularEtiquetasAoEstabelecimento(comando));
		
		Estabelecimento estabelecimento = new Estabelecimento(comando);

		return super.salvar(estabelecimento);
	}

	public Estabelecimento atualizar(String id, SalvarEstabelecimentoCommand comando) {		
		Estabelecimento estabelecimento = super.get(id);

		EnderecoDTO enderecoDTO = new EnderecoDTO(comando.getCep(),
				   comando.getRua(),
				   comando.getNumero(),
				   comando.getComplemento(),
				   comando.getBairro(),
				   comando.getCidade(),
				   comando.getEstado(),
				   comando.getLocalizacao());		
		
		Endereco endereco = estabelecimento.getEndereco();
		endereco.setByEnderecoVO(enderecoDTO);
		comando.setEndereco(endereco);
		
		//vincularEtiquetasAoEstabelecimento(comando);
		
		estabelecimento.atualizar(comando);
		
		return super.salvar(estabelecimento);
	}

	public List<Evento> getEventoByEstabelecimento(String id) {
		return eventoService.getEventoByEstabelecimento(id);
	}

    public void vincularUsuario(String id, VincularUsuarioComEstabelecimentoCommand comando) {
        Estabelecimento estabelecimento = get(id);

        if(!estabelecimento.getDono().equals(AuthenticationContext.getCurrentUserId())) {
            throw new AccessDeniedException("Você não pode criar um usuario a um estabelecimento que você não é dono.");
        }

        User usuario = userService.getUsuarioOuPreCriar(comando.getEmail());
        userService.vincularComEstabelecimento(usuario, id, comando);
    }
    
	private EstabelecimentoCategoria getCategoria(String idCategoria) {
		return categoriaService.get(idCategoria);
	} 

	private Endereco criarEndereco(EnderecoDTO enderecoDTO) {
		return enderecoService.criar(enderecoDTO);
	}

	public List<Voucher> getVouchersByEstabelecimento(String id) {
		return voucherService.getByEstabelecimento(id);
	}

	public void remover(String id) {
	    voucherService.removerTodosPorEstabeleciemto(id);
	    eventoService.removerTodosPorEstabelecimento(id);
	    super.remover(id);
    }

	public List<Estabelecimento> getAllToUsuarioComum() {
		return repository.findByEnderecoCidade(AuthenticationContext.getCurrentUser().getCidade());
	}

}
