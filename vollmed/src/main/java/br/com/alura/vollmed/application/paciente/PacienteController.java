package br.com.alura.vollmed.application.paciente;

import br.com.alura.vollmed.domain.paciente.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody DadosPaciente dados){
        service.cadastrarPaciente(dados);
    }

    @GetMapping
    public List<DadosPaciente> listarPacientes(){
        return service.listarTodos();
    }




}
