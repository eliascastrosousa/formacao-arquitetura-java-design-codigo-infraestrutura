package br.com.alura.vollmed.infra.consulta;

import br.com.alura.vollmed.infra.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {
}
