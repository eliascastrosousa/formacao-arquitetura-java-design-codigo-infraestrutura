package br.com.alura.codechella.application.usecases.usuario;

import br.com.alura.codechella.application.gateways.usuario.RepositorioDeUsuario;

public class ExcluirUsuario {
    private final RepositorioDeUsuario repositorio;

    public ExcluirUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public void excluirUsuario(String cpf) {
        repositorio.excluirUsuario(cpf);
    }
}
