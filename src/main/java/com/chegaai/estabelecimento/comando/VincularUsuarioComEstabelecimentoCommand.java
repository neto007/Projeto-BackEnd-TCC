package com.chegaai.estabelecimento.comando;

import java.util.List;

import com.chegaai.user.permissao.UserPermissao;

public class VincularUsuarioComEstabelecimentoCommand {
    private String email;

    private List<String> permissoes;

    private List<UserPermissao> usuarioPermissoes;


    public String getEmail() {
        return email;
    }

    public List<String> getPermissoes() {
        return permissoes;
    }

    public List<UserPermissao> getUsuarioPermissoes() {
        return usuarioPermissoes;
    }

    public void setUsuarioPermissoes(List<UserPermissao> usuarioPermissoes) {
        this.usuarioPermissoes = usuarioPermissoes;
    }
}
