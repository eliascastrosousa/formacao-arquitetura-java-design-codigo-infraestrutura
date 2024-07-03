package br.com.alura.codechella.vendas;

import br.com.alura.codechella.vendas.dominio.evento.Categoria;
import br.com.alura.codechella.vendas.dominio.evento.Evento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class CodechellaApplicationTests {

	@Test
	void TesteFabricaDeEvento () {
		Evento evento = new Evento.Builder()
				.comDescricao("Rubel - Casas")
				.comCategoria(Categoria.MUSICA)
				.comData(LocalDateTime.now().plusDays(7))
				.comEndereco("07082560", 77, "conjunto 10")
				.build();

		Assertions.assertEquals("07082560", evento.getEndereco().getCep());
	}

}
