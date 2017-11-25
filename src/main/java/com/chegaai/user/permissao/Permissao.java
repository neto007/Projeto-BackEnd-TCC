package com.chegaai.user.permissao;

public enum Permissao {
    CRIAR_ESTABELECIMENTO("criar_estabelecimento"),
    ATUALIZAR_ESTABELECIMENTO("atualizar_estabelecimento");

    private final String value;

    Permissao(String key) {
        this.value = key;
    }

    public String getValue() {
        return value;
    }
}
