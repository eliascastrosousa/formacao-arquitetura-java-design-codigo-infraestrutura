package br.com.alura.codechella.application.usecases.usuario;


import br.com.alura.codechella.application.gateways.usuario.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class CriarUsuario {

    private final RepositorioDeUsuario repositorio;

    public CriarUsuario(RepositorioDeUsuario repositorio) {

        this.repositorio = repositorio;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {

        return repositorio.cadastrarUsuario(usuario);
    }

}
