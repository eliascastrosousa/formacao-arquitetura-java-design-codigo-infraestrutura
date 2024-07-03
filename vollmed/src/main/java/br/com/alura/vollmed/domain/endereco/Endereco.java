package br.com.alura.vollmed.domain.endereco;

import br.com.alura.vollmed.application.endereco.DadosEndereco;

public class Endereco {
    private String cep;
    private String logradouro;
    private int numero;
    private  String complemento;

    public Endereco(String cep, String logradouro, int numero, String complemento){
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }
}
