package br.com.alura.vollmed.application.medico;

import br.com.alura.vollmed.application.endereco.DadosEndereco;
import br.com.alura.vollmed.infra.medico.Especialidade;

public record DadosMedico(
        String crm,
        String nome,
        Especialidade especialidade,
        DadosEndereco endereco) {

}
