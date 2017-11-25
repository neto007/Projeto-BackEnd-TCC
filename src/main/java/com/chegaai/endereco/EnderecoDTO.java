package com.chegaai.endereco;

public class EnderecoDTO {
    
    private String cep;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Localizacao localizacao;    
    
    public EnderecoDTO(String cep, String rua, String numero, String complemento, String bairro, String cidade,
            String estado, Localizacao localizacao) {
        super();
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.localizacao = localizacao;
    }

    public String getCep() {
        return cep;
    }
    
    public String getRua() {
        return rua;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public String getComplemento() {
        return complemento;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public String getEstado() {
        return estado;
    }

	public Localizacao getLocalizacao() {
		return localizacao;
	}
    
}