package br.com.alura.vollmed.application.medico;

import br.com.alura.vollmed.application.endereco.DadosEndereco;
import br.com.alura.vollmed.application.paciente.DadosPaciente;
import br.com.alura.vollmed.infra.medico.Medico;
import br.com.alura.vollmed.infra.medico.MedicoRepository;
import br.com.alura.vollmed.infra.paciente.Paciente;
import br.com.alura.vollmed.infra.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public DadosMedico cadastrarMedico(DadosMedico dados) {
        var medico = new Medico(dados);
        repository.save(medico);
        return converteDados(medico);
    }

    public List<DadosMedico> listarTodos() {
        List<Medico> medicos = repository.findAll();
        return medicos.stream()
                .map(this::converteDados)
                .collect(Collectors.toList());
    }

    private DadosMedico converteDados(Medico medico) {

        return new DadosMedico(
                medico.getCrm(),
                medico.getNome(),
                medico.getEspecialidade(),
                new DadosEndereco(
                        medico.getEndereco().getCep(),
                        medico.getEndereco().getLogradouro(),
                        medico.getEndereco().getNumero(),
                        medico.getEndereco().getComplemento())
        );

    }
}
