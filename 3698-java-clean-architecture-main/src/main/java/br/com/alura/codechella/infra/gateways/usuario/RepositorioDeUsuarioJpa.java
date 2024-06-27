package br.com.alura.codechella.infra.gateways.usuario;

import br.com.alura.codechella.application.gateways.usuario.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.usuario.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.usuario.UsuarioRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repository;

    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Usuario buscarUsuario(String cpf) {
        UsuarioEntity entity = repository.findByCpf(cpf);
        return mapper.toDomain(entity);
    }

    @Override
    public Usuario alteraUsuario(String cpf, Usuario usuario) {
        UsuarioEntity entity = repository.findByCpf(cpf);
        System.out.println(entity);
        if (entity != null) {
            var atualizar = mapper.toEntity(usuario);
            if (!Objects.equals(entity.getNome(), atualizar.getNome()) && atualizar.getNome() != null){
                entity.setNome(atualizar.getNome());
            }
            if (!Objects.equals(entity.getNascimento(), atualizar.getNascimento()) && atualizar.getNascimento() != null){
                entity.setNascimento(atualizar.getNascimento());
            }
            if (!Objects.equals(entity.getEmail(), atualizar.getEmail()) && atualizar.getEmail() != null){
                entity.setEmail(atualizar.getEmail());
            }
            repository.save(entity);
            return mapper.toDomain(entity);
        }
        return null;
    }

    @Override
    public void excluirUsuario(String cpf) {
        UsuarioEntity entity = repository.findByCpf(cpf);
        repository.deleteById(entity.getId());
    }


}
