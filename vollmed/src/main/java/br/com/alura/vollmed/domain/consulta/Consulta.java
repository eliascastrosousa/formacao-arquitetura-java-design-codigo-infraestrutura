package br.com.alura.vollmed.domain.consulta;

import java.time.LocalDateTime;

public class Consulta {
    private String crmMedico;
    private String cpfPaciente;
    private LocalDateTime dataHoraConsulta;
    private StatusConsulta statusConsulta;

    public Consulta() {
    }

    public Consulta(String crmMedico, String cpfPaciente, LocalDateTime dataHoraConsulta, StatusConsulta statusConsulta) {
        this.crmMedico = crmMedico;
        this.cpfPaciente = cpfPaciente;
        this.dataHoraConsulta = dataHoraConsulta;
        this.statusConsulta = statusConsulta;
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
                "crmMedico='" + crmMedico + '\'' +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                ", dataHoraConsulta=" + dataHoraConsulta +
                ", statusConsulta=" + statusConsulta +
                '}';
    }

}
