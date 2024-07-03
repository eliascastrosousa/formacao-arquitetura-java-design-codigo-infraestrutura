package br.com.alura.vollmed.application.medico;

import br.com.alura.vollmed.application.paciente.DadosPaciente;
import br.com.alura.vollmed.application.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @GetMapping("/teste")
    public String testeMedicos(){
        return "medicos aqui";
    }

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody DadosMedico dados){
        service.cadastrarMedico(dados);
    }

    @GetMapping
    public List<DadosMedico> listarMedicos(){
        return service.listarTodos();
    }

}
