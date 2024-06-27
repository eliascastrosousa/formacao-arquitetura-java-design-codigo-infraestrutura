package br.com.alura.codechella.domain.entities.usuario;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsuarioDTO(
        String cpf,
        String nome,
        LocalDate nascimento,
        String email) {
}
