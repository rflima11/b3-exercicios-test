package tech.ada.rflima.b3testesexercicios.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.ada.rflima.b3testesexercicios.entity.Usuario;
import tech.ada.rflima.b3testesexercicios.exception.UsuarioNaoEncontradoException;
import tech.ada.rflima.b3testesexercicios.repository.UsuarioRepository;
import tech.ada.rflima.b3testesexercicios.repository.UsuarioRepositoryTest;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class DeletarUsuarioServiceTest {

    @Mock
    UsuarioRepository repositoryMock;

    @InjectMocks
    DeletarUsuarioService deletarUsuarioService;


    @Test
    void deveDeletarUmUsuarioEncontradoComSucesso() {
        //Cenário
        Long id = 1L;
        Usuario usuario = new Usuario(
                "Rodolfo",
                "04747103198",
                30,
                LocalDateTime.now()
        );
        Mockito.when(repositoryMock.findById(id))
                .thenReturn(Optional.of(usuario));

        //Execução
        deletarUsuarioService.deletarUsuario(id);

        //Verificação
        Mockito.verify(repositoryMock, Mockito.times(1)).delete(usuario);
    }

    @Test
    void deveLancarUmaExcecaoAoNaoEncontrarUmUsuario() {
        //Cenário
        Long id = 1L;
        Mockito.when(repositoryMock.findById(id))
                .thenReturn(Optional.empty());

        //Execução
        UsuarioNaoEncontradoException usuarioNaoEncontradoException =
                Assertions.assertThrows(UsuarioNaoEncontradoException.class,
                () -> deletarUsuarioService.deletarUsuario(id));


        //Verificação
        Assertions.assertNotNull(usuarioNaoEncontradoException);
        Assertions.assertEquals(String.format("Usuário não encontrado com o ID %s", id),
                usuarioNaoEncontradoException.getMessage());
    }

}