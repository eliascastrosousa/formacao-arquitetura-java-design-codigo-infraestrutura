package br.com.alura.codechella.infra.gateways.usuario;

import br.com.alura.codechella.application.gateways.usuario.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioEmArquivo implements RepositorioDeUsuario {

    List<Usuario> usuarios = new ArrayList<>();
    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }

    public void gravaEmArquivo(String nome) throws IOException {
        FileWriter file = new FileWriter(nome);
        file.write(usuarios.toString());
        file.close();
    }

    @Override
    public Usuario buscarUsuario(String cpf) {
        return null;
        //return usuarios.stream().filter(usuario -> usuario.getCpf().contains(cpf)).collect(Collectors.toList());
    }

    @Override
    public Usuario alteraUsuario(String cpf, Usuario usuario) {
        return null;
    }

    @Override
    public void excluirUsuario(String cpf) {

    }
}
