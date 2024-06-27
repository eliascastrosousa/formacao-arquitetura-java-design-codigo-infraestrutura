package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.usuario.RepositorioDeUsuarioEmArquivo;

import java.io.IOException;
import java.time.LocalDate;

public class UtilizaUsuarioComArquivo {
    public static void main(String[] args) throws IOException {
        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-99", "joao", LocalDate.parse("2000-10-15"), "joao@email.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-88", "maria", LocalDate.parse("2000-10-15"), "maria@email.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-77", "rafael", LocalDate.parse("2000-10-15"), "rafael@email.com"));

        System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());

        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuarios.txt");

    }
}
