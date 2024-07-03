package br.com.alura.vollmed.application.consulta;

import br.com.alura.vollmed.application.endereco.DadosEndereco;
import br.com.alura.vollmed.application.medico.DadosMedico;
import br.com.alura.vollmed.infra.consulta.Consulta;
import br.com.alura.vollmed.infra.consulta.ConsultaRepository;
import br.com.alura.vollmed.infra.medico.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public DadosConsulta cadastrarConsulta(DadosConsulta dados) {
        var consulta = new Consulta(dados);
        repository.save(consulta);
        return converteDados(consulta);
    }

    public List<DadosConsulta> listarTodos() {
        List<Consulta> consultas = repository.findAll();
        return consultas.stream()
                .map(this::converteDados)
                .collect(Collectors.toList());
    }

    private DadosConsulta converteDados(Consulta consulta) {

        return new DadosConsulta(
                consulta.getUuid(),
                consulta.getCrmMedico(),
                consulta.getCpfPaciente(),
                consulta.getDataHoraConsulta(),
                consulta.getStatusConsulta());

    }
}
