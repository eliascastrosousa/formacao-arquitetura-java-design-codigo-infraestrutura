package br.com.alura.vollmed.application.endereco;
import br.com.alura.vollmed.domain.endereco.Endereco;

public record DadosEndereco(
        String cep,
        String logradouro,
        int numero,
        String complemento ) {
//    public DadosEndereco(Endereco endereco){
//        this(endereco.getCep(), endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento());
//    }
}
