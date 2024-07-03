package br.com.alura.vollmed.application.paciente;

import br.com.alura.vollmed.application.endereco.DadosEndereco;

import java.util.UUID;

public record DadosPaciente(
        String cpf,
        String nome,
        String telefone,
        DadosEndereco endereco) {





}
