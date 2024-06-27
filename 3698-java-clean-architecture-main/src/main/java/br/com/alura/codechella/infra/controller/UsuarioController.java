package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.usuario.*;
import br.com.alura.codechella.domain.entities.usuario.DadosAtualizacaoUsuarioDTO;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.domain.entities.usuario.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final BuscarUsuario buscarUsuario;
    private final AlterarUsuario alterarUsuario;
    private final ExcluirUsuario excluirUsuario;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios, BuscarUsuario buscarUsuario, AlterarUsuario alterarUsuario, ExcluirUsuario excluirUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.buscarUsuario = buscarUsuario;
        this.alterarUsuario = alterarUsuario;
        this.excluirUsuario = excluirUsuario;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody UsuarioDTO dto, UriComponentsBuilder uriBuilder ){
        Usuario user = criarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(user.getCpf(), user.getNome(), user.getNascimento(), user.getEmail()));
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios(){
        return listarUsuarios.listarUsuarios().stream()
                .map(u -> new UsuarioDTO(
                        u.getCpf(),
                        u.getNome(),
                        u.getNascimento(),
                        u.getEmail())
                ).collect(Collectors.toList());

    }

    @GetMapping("/{cpf}")
    public ResponseEntity buscarUsuario(@PathVariable String cpf){
        var user = buscarUsuario.buscarUsuario(cpf);
        return  ResponseEntity.ok(new UsuarioDTO(user.getCpf(), user.getNome(), user.getNascimento(), user.getEmail()));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity atualizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDTO dto ){
        Usuario atualizado = alterarUsuario.alterarDadosUsuario(cpf,
                new Usuario(
                        dto.cpf(),
                        dto.nome(),
                        dto.nascimento(),
                        dto.email()));

        return ResponseEntity.ok(new UsuarioDTO(
                atualizado.getCpf(),
                atualizado.getNome(),
                atualizado.getNascimento(),
                atualizado.getEmail()));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity excluirUsuario(@PathVariable String cpf) {
        excluirUsuario.excluirUsuario(cpf);
        return ResponseEntity.noContent().build();
    }






}
