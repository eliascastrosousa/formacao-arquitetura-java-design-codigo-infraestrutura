package br.com.alura.vollmed.infra.consulta;


import br.com.alura.vollmed.application.consulta.DadosConsulta;
import br.com.alura.vollmed.infra.consulta.StatusConsulta;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String crmMedico;
    private String cpfPaciente;
    private LocalDateTime dataHoraConsulta;

    @Enumerated(EnumType.STRING)
    private StatusConsulta statusConsulta;

    public Consulta() {
    }

    public Consulta(DadosConsulta dados) {
        this.uuid = dados.uuid();
        this.crmMedico = dados.crmMedico();
        this.cpfPaciente = dados.cpfPaciente();
        this.dataHoraConsulta = dados.dataHoraConsulta();
        this.statusConsulta = StatusConsulta.AGENDADA;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "uuid=" + uuid +
                ", crmMedico='" + crmMedico + '\'' +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                ", dataHoraConsulta=" + dataHoraConsulta +
                ", statusConsulta=" + statusConsulta +
                '}';
    }
}
