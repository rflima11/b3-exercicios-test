package tech.ada.rflima.b3testesexercicios.service;

import org.springframework.stereotype.Service;
import tech.ada.rflima.b3testesexercicios.entity.Usuario;
import tech.ada.rflima.b3testesexercicios.exception.UsuarioNaoEncontradoException;
import tech.ada.rflima.b3testesexercicios.repository.UsuarioRepository;

@Service
public class DeletarUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public DeletarUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void deletarUsuario(Long id) {
        Usuario usuarioBancoDeDados = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(String.format("Usuário não encontrado com o ID %s", id)));
        usuarioRepository.delete(usuarioBancoDeDados);
    }
}
