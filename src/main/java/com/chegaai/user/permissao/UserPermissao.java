package com.chegaai.user.permissao;


import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserPermissao {

    @Id
    private String id;

    private String permissao;

    private String estabelecimentoId;

    private UserPermissao() {
        id = UUID.randomUUID().toString();
    }

    public UserPermissao(String permissao, String estabelecimentoId) {
        this();
        this.permissao = permissao;
        this.estabelecimentoId = estabelecimentoId;
    }

    public String getId() {
        return id;
    }

    public String getPermissao() {
        return permissao;
    }

    public String getEstabelecimentoId() {
        return estabelecimentoId;
    }
}
