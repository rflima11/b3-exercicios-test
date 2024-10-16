package tech.ada.rflima.b3testesexercicios.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.ada.rflima.b3testesexercicios.entity.Usuario;
import tech.ada.rflima.b3testesexercicios.repository.UsuarioRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class BuscarUsuarioServiceTest {

    @InjectMocks
    BuscarUsuarioService service;

    @Mock
    UsuarioRepository usuarioRepositoryMock;

    @Test
    void deveBuscarUmUsuarioPorCPFComSucesso() {
        //Cenário
        String cpf = "04747103198";
        Usuario usuarioRetorno = new Usuario(
                "Rodolfo",
                cpf,
                30,
                LocalDateTime.now()
        );

        Mockito.when(usuarioRepositoryMock.findByCpf(cpf))
                .thenReturn(Optional.of(usuarioRetorno));

        //Execução
        Usuario usuario = service.buscarUsuarioPorCPF(cpf);

        //Verificação
        Assertions.assertNotNull(usuario);
        Assertions.assertEquals(cpf, usuario.getCpf());
    }

    @Test
    void deveRetornarNuloAoNaoEncontrarUmUsuario() {
        //Cenário
        String cpf = "047472013";

        Mockito.when(usuarioRepositoryMock.findByCpf(cpf))
                .thenReturn(Optional.empty());

        //Execução
        Usuario usuario = service.buscarUsuarioPorCPF(cpf);


        //Verificação
        Assertions.assertNull(usuario);
    }
}