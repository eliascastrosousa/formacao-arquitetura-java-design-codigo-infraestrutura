package br.com.alura.codechella.application.usecases.usuario;

import br.com.alura.codechella.application.gateways.usuario.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class BuscarUsuario {
    private final RepositorioDeUsuario repositorio;

    public BuscarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario buscarUsuario(String cpf) {
        return repositorio.buscarUsuario(cpf);
    }
}
