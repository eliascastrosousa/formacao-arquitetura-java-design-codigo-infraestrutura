package br.com.alura.vollmed.infra.paciente;

import br.com.alura.vollmed.application.paciente.DadosPaciente;
import br.com.alura.vollmed.infra.endereco.Endereco;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    private String cpf;
    private String nome;
    private String telefone;
    @Embedded
    private Endereco endereco;
    public Paciente(DadosPaciente dados){
        this.cpf = dados.cpf();
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public Paciente(){}


    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }


    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
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
