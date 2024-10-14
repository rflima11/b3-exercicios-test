package tech.ada.rflima.b3testesexercicios.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tech.ada.rflima.b3testesexercicios.entity.Usuario;
import tech.ada.rflima.b3testesexercicios.repository.UsuarioExistenteException;
import tech.ada.rflima.b3testesexercicios.repository.UsuarioRepository;
import tech.ada.rflima.b3testesexercicios.repository.UsuarioRepositoryTest;

import java.time.LocalDateTime;
import java.util.Optional;

class CriarUsuarioServiceTest {

    CriarUsuarioService criarUsuarioService;
    UsuarioRepository repository;
    BuscarUsuarioService buscarUsuarioService;

    @BeforeEach
    public void setUp() {
        repository = Mockito.mock(UsuarioRepository.class);
        buscarUsuarioService = new BuscarUsuarioService(repository);
        criarUsuarioService = new CriarUsuarioService(repository, buscarUsuarioService);
    }

    @Test
    void deveCriarUmUsuarioComSucesso() {
        //Cenário
        String nome = "Rodolfo";
        int idade = 30;
        String cpf = "047472038";
        LocalDateTime dataHoraCriacao = LocalDateTime.now();
        Usuario usuarioRetorno = new Usuario(
                nome,
                cpf,
                idade,
                dataHoraCriacao
        );
        usuarioRetorno.setId(1L);


        Mockito.when(repository.save(Mockito.any(Usuario.class)))
                .thenReturn(usuarioRetorno);

        //Execução
        Usuario usuario = criarUsuarioService.criarUsuario(nome, idade, cpf);

        //Verificação
        Assertions.assertNotNull(usuario);
        Assertions.assertNotNull(usuario.getId());
        Assertions.assertNotNull(usuario.getNome());
        Assertions.assertNotNull(usuario.getCpf());
        Assertions.assertNotNull(usuario.getDataHoraCriacao());
    }


    @Test
    void deveLancarExcecaoCasoUmUsuarioJaTenhaSidoCadastrado() {

        //Cenário
        String nome = "Rodolfo";
        int idade = 30;
        String cpf = "047472038";

        Mockito.when(repository.findByCpf(cpf))
                .thenReturn(Optional.of(new Usuario()));

        //Execução e Verificação
        UsuarioExistenteException usuarioExistenteException = Assertions.assertThrows(UsuarioExistenteException.class, () -> criarUsuarioService.criarUsuario(nome, idade, cpf));


        //Verificação
        Assertions.assertNotNull(usuarioExistenteException);
        Assertions.assertEquals(String.format("Usuário com CPF %s já existe", cpf), usuarioExistenteException.getMessage());
    }
}