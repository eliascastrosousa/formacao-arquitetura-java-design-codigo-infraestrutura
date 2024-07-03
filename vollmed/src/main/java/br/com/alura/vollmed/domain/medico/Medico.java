package br.com.alura.vollmed.domain.medico;

import br.com.alura.vollmed.application.medico.DadosMedico;
import br.com.alura.vollmed.domain.endereco.Endereco;
import br.com.alura.vollmed.domain.paciente.Paciente;

import java.util.UUID;

public class Medico {
    private String crm;
    private String nome;
    private Especialidade especialidade;
    private Endereco endereco;

    public Medico(){}

    public Medico(String crm, String nome, Especialidade especialidade, Endereco endereco){
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public static class Builder {

        private Medico medico;

        public Builder() {
            medico = new Medico();
        }
        public Builder comCrm(String crm) {
            medico.crm = crm;
            return this;
        }
        public Builder comNome(String nome) {
            medico.nome = nome;
            return this;
        }
        public Builder comEspecialidade(Especialidade especialidade) {
            medico.especialidade = especialidade;
            return this;
        }

        public Builder comEndereco(String cep, String logradouro, int numero, String complemento){
            Endereco endereco = new Endereco(cep, logradouro, numero, complemento);
            medico.endereco = endereco;
            return this;
        }
        public Medico Build() {
            return medico;
        }
    }


}

