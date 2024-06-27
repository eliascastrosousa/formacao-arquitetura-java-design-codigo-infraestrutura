package br.com.alura.codechella.entities.domain;

import br.com.alura.codechella.domain.entities.usuario.FabricaDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Usuario("123456789-11", "joao maria", LocalDate.parse("1996-10-01"), "joaomaria@gmail.com"));
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Usuario("12345678911", "joao maria", LocalDate.parse("1996-10-01"), "joaomaria@gmail.com"));
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Usuario("123.456.789.11", "joao maria", LocalDate.parse("1996-10-01"), "joaomaria@gmail.com"));
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Usuario("", "joao maria", LocalDate.parse("1996-10-01"), "joaomaria@gmail.com"));

    }

    @Test
    public void deveCriarUsuarioComFabrica(){
        FabricaDeUsuario fabricaDeUsuario = new FabricaDeUsuario();

        Usuario usuario1 = fabricaDeUsuario.comNomeCpfNascimento("joao maria", "123.456.789-11", LocalDate.parse("2000-01-10"));
        Assertions.assertEquals("joao maria", usuario1.getNome());

        Usuario usuario2 = fabricaDeUsuario.cadastroCompleto("maria joao","321.456.789-11", LocalDate.parse("2000-10-01"), "maria_joao@gmail.com");
        Assertions.assertEquals("maria joao", usuario2.getNome());

        usuario1 = fabricaDeUsuario.incluiEndereco("12345-678", 1, "casa");
        Assertions.assertEquals(1, usuario1.getEndereco().getNumero());

        usuario2 = fabricaDeUsuario.incluiEndereco("12345-678", 1, "casa");
        Assertions.assertEquals(1, usuario2.getEndereco().getNumero());

    }

    @Test
    public void naoDeveCriarUsuarioComIdadeMenor18() {
        LocalDate dataNascimento = LocalDate.now().minusYears(17);  // Um usuário com 17 anos

        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Usuario(
                        "123456789-11",
                        "joao maria",
                        dataNascimento,
                        "joaomaria@gmail.com")
        );
    }
    }
