package br.com.alura.codechella.application.gateways.usuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import java.util.List;

public interface RepositorioDeUsuario {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario buscarUsuario(String cpf);

    Usuario alteraUsuario(String cpf, Usuario usuario);

    void excluirUsuario(String cpf);

}
