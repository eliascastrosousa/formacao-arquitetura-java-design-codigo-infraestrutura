package br.com.alura.vollmed.infra.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
}
