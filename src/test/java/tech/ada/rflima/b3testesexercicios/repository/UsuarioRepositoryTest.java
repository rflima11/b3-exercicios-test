package tech.ada.rflima.b3testesexercicios.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tech.ada.rflima.b3testesexercicios.entity.Usuario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//Qual anotação devemos usar para subir o contexto do spring relacionado a persistência de dados?
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository usuarioRepository;

    Usuario usuarioInicial;

    String cpf;

    @BeforeEach
    public void setUp() {
        cpf = "33377755534";
        usuarioInicial = new Usuario(
                "Helena",
                cpf,
                4,
                LocalDateTime.now()
        );

        usuarioRepository.save(usuarioInicial);
    }


    @Test
    void deveSalvarUsuarioComSucesso() {
        Usuario usuario = new Usuario(
                "Rodolfo",
                "04747103198",
                30,
                LocalDateTime.now()
        );

        Usuario retorno = usuarioRepository.save(usuario);

        Long idSalvo = usuario.getId();
        Assertions.assertNotNull(retorno);
        Assertions.assertEquals("Rodolfo", retorno.getNome());
        Assertions.assertEquals("04747103198", retorno.getCpf());
        Assertions.assertNotNull(idSalvo);
    }


    @Test
    void deveListarTodosOsUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        Assertions.assertNotNull(usuarios);
        Assertions.assertFalse(usuarios.isEmpty());
    }

    @Test
    void deveEncontrarUsuarioPorCpf() {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCpf(cpf);

        Assertions.assertTrue(usuarioOptional.isPresent());
        Assertions.assertEquals(cpf, usuarioOptional.get().getCpf());
    }

    @Test
    void deveAtualizarUsuario() {
        //Cenário
        String nomeAntigo = usuarioInicial.getNome();
        Long idAntigo = usuarioInicial.getId();
        String nomeNovo = nomeAntigo + " - ATUALIZADO";
        Usuario usuario = usuarioRepository.findByCpf(cpf).orElseThrow();
        usuario.setNome(nomeNovo);

        //Execução
        Usuario retorno = usuarioRepository.save(usuario);


        //Validações
        Assertions.assertNotEquals(nomeAntigo, retorno.getNome());
        Assertions.assertEquals(idAntigo, retorno.getId());
    }


    @Test
    void deveDeletarUsuario() {
        usuarioRepository.delete(usuarioInicial);

        Optional<Usuario> usuarioPorId = usuarioRepository.findById(usuarioInicial.getId());

        Assertions.assertTrue(usuarioPorId.isEmpty());
    }

}
