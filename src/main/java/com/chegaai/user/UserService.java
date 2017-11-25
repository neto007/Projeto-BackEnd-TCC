package com.chegaai.user;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.commons.AbstractService;
import com.chegaai.estabelecimento.categoria.EstabelecimentoCategoria;
import com.chegaai.estabelecimento.categoria.EstabelecimentoCategoriaService;
import com.chegaai.estabelecimento.comando.VincularUsuarioComEstabelecimentoCommand;
import com.chegaai.exception.PermissaoInvalidaException;
import com.chegaai.user.comando.AtualizarCidadeUsuarioCommand;
import com.chegaai.user.comando.VincularUsuarioComEstabelecimentoCategoriaCommand;
import com.chegaai.user.permissao.Permissao;
import com.chegaai.user.permissao.UserPermissao;
import com.chegaai.user.permissao.UserPermissaoService;

@Transactional
@Service("UserService")
public class UserService extends AbstractService<User, UserRepository> {

    @Autowired
    private UserPermissaoService userPermissaoService;
    
    @Autowired
    private EstabelecimentoCategoriaService estabelecimentoCategoriaService;

    public User getUsuarioOuPreCriar(String email) {
        User usuario = repository.findByEmail(email);

        if(usuario != null) {
            return usuario;
        }

        return preCriaUsuario(email);
    }

    private User preCriaUsuario(String email) {
        User usuario = new User(email);
        return this.salvar(usuario);
    }

    public void vincularComEstabelecimento(User usuario, String estabelecimentoId, VincularUsuarioComEstabelecimentoCommand comando) {
        List<UserPermissao> permissoes = new ArrayList<UserPermissao>();

        for (String permissaoNome : comando.getPermissoes()) {
            permissoes.add(
                criarUsuarioPermissao(permissaoNome, estabelecimentoId)
            );
        }

        comando.setUsuarioPermissoes(permissoes);
        usuario.vincularComEstabelecimento(comando);
        this.salvar(usuario);
    }
    
    public void vincularComInteresse(VincularUsuarioComEstabelecimentoCategoriaCommand comando) {
    	
    	List<EstabelecimentoCategoria> estabelecimentoCategorias = new ArrayList<EstabelecimentoCategoria>();
    			
    	for (String interesseId : comando.getInteresses()) {
    		estabelecimentoCategorias.add(estabelecimentoCategoriaService.get(interesseId));
		}

    	comando.setCategorias(estabelecimentoCategorias);
    	User usuario = AuthenticationContext.getCurrentUser();
    	usuario.vincularComInteresse(comando);
        this.salvar(usuario);
    }

    private UserPermissao criarUsuarioPermissao(String permissaoNome, String estabelecimentoId) {

        if(Permissao.valueOf(permissaoNome) == null) {
            throw new PermissaoInvalidaException("Permissão "+ permissaoNome +" inválida!");
        }

        UserPermissao permissao = new UserPermissao(permissaoNome, estabelecimentoId);
        userPermissaoService.salvar(permissao);

        return permissao;
    }

	public void atualizarCidade(AtualizarCidadeUsuarioCommand comando) {
		String id = AuthenticationContext.getCurrentUserId();
		repository.updateCidade(id, comando.getCidade());
	}
}
