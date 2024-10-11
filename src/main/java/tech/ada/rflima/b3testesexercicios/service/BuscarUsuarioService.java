package tech.ada.rflima.b3testesexercicios.service;

import org.springframework.stereotype.Service;
import tech.ada.rflima.b3testesexercicios.entity.Usuario;
import tech.ada.rflima.b3testesexercicios.exception.UsuarioNaoEncontradoException;
import tech.ada.rflima.b3testesexercicios.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class BuscarUsuarioService {

    private final UsuarioRepository usuarioRepository;


    public BuscarUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarUsuarioPorCPF(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou em branco");
        }

        return usuarioRepository.findByCpf(cpf)
                .orElse(null);
    }
}
