package br.com.alura.vollmed.infra.endereco;

import br.com.alura.vollmed.application.endereco.DadosEndereco;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String cep;
    private String logradouro;
    private int numero;
    private  String complemento;

    public Endereco() {}

    public Endereco(DadosEndereco dados) {
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
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
