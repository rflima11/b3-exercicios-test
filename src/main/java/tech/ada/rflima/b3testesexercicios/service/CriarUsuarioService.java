package tech.ada.rflima.b3testesexercicios.service;

import org.springframework.stereotype.Service;
import tech.ada.rflima.b3testesexercicios.entity.Usuario;
import tech.ada.rflima.b3testesexercicios.repository.UsuarioExistenteException;
import tech.ada.rflima.b3testesexercicios.repository.UsuarioRepository;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class CriarUsuarioService {

    private final UsuarioRepository repository;
    private final BuscarUsuarioService buscarUsuarioService;

    public CriarUsuarioService(UsuarioRepository repository, BuscarUsuarioService buscarUsuarioService) {
        this.repository = repository;
        this.buscarUsuarioService = buscarUsuarioService;
    }

    public Usuario criarUsuario(String nome, int idade, String cpf) {
        Usuario usuarioExistente = buscarUsuarioService.buscarUsuarioPorCPF(cpf);

        if (usuarioExistente != null) {
            throw new UsuarioExistenteException(String.format("Usuário com CPF %s já existe", cpf));
        }
        LocalDateTime dataHoraCriacao = LocalDateTime.now(Clock.system(ZoneId.systemDefault()));
        Usuario usuario = new Usuario(nome, cpf, idade, dataHoraCriacao);
        return repository.save(usuario);
    }

}
