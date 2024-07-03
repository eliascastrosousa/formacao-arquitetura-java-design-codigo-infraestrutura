package br.com.alura.vollmed.application.paciente;

import br.com.alura.vollmed.application.endereco.DadosEndereco;
import br.com.alura.vollmed.infra.paciente.Paciente;
import br.com.alura.vollmed.infra.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public DadosPaciente cadastrarPaciente(DadosPaciente dados) {
        var paciente = new Paciente(dados);
        repository.save(paciente);
        return  converteDados(paciente);
    }

    public List<DadosPaciente> listarTodos() {
        List<Paciente> pacientes = repository.findAll();
        return pacientes.stream()
                .map(this::converteDados)
                .collect(Collectors.toList());
    }

    private DadosPaciente converteDados(Paciente paciente) {

        return new DadosPaciente(
                paciente.getCpf(),
                paciente.getNome(),
                paciente.getTelefone(),
                new DadosEndereco(
                        paciente.getEndereco().getCep(),
                        paciente.getEndereco().getLogradouro(),
                        paciente.getEndereco().getNumero(),
                        paciente.getEndereco().getComplemento())
                 );

    }




}
