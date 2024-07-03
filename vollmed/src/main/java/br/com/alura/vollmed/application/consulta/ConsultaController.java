package br.com.alura.vollmed.application.consulta;

import br.com.alura.vollmed.application.medico.DadosMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @Transactional
    public void cadastrarConsulta(@RequestBody DadosConsulta dados){
        consultaService.cadastrarConsulta(dados);
    }

    @GetMapping
    public List<DadosConsulta> listarConsultas(){
        return consultaService.listarTodos();
    }


    @GetMapping("/teste")
    public String testeConsulta(){
        return "requisição com sucesso";
    }
}
