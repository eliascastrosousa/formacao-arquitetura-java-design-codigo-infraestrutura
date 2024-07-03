package br.com.alura.vollmed.domain.paciente;
import br.com.alura.vollmed.application.endereco.DadosEndereco;
import br.com.alura.vollmed.domain.endereco.Endereco;

import java.util.UUID;

public class Paciente {

    private String cpf;
    private String nome;
    private String telefone;
    private Endereco endereco;

    public Paciente() {
    }

    public Paciente(String cpf, String nome, String telefone, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public static class Builder{

        private Paciente paciente;

        public Builder(){
            paciente = new Paciente();
        }

        public Builder comCpf(String cpf){
            paciente.cpf = cpf;
            return this;
        }

        public Builder comNome(String nome){
            paciente.nome = nome;
            return this;
        }

        public Builder comTelfone(String telefone){
            paciente.telefone = telefone;
            return this;
        }

        public Builder comEndereco(String cep, String logradouro, int numero, String complemento){
            Endereco endereco = new Endereco(cep, logradouro, numero, complemento);
            paciente.endereco = endereco;
            return this;
        }

        public Paciente Build(){
            return paciente;
        }

    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
