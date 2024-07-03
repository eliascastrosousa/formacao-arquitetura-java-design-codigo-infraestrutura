package br.com.alura.vollmed.application.consulta;

import br.com.alura.vollmed.infra.consulta.StatusConsulta;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosConsulta(
        UUID uuid,
        String crmMedico,
        String cpfPaciente,
        LocalDateTime dataHoraConsulta,
        StatusConsulta statusConsulta
) {
}
