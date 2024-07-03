package br.com.alura.vollmed.infra.medico;

import br.com.alura.vollmed.infra.endereco.Endereco;
import br.com.alura.vollmed.application.medico.DadosMedico;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "medicos")
public class Medico {
    @Id
    private String crm;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;


    public Medico() {
    }

    public Medico (DadosMedico dados){
        this.crm = dados.crm();
        this.nome = dados.nome();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }
    public String getCrm() {
        return crm;
    }

    public String getNome() {
        return nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "crm='" + crm + '\'' +
                ", nome='" + nome + '\'' +
                ", especialidade=" + especialidade +
                ", endereco=" + endereco +
                '}';
    }
}
