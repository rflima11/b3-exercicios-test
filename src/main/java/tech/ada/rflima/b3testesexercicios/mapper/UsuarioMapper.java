package tech.ada.rflima.b3testesexercicios.mapper;

import tech.ada.rflima.b3testesexercicios.dto.UsuarioDTO;
import tech.ada.rflima.b3testesexercicios.entity.Usuario;

public final class UsuarioMapper {
    private UsuarioMapper() {}

    public static Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setIdade(usuarioDTO.getIdade());
        return usuario;
    }

    public static UsuarioDTO toDTO(Usuario entity) {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setIdade(entity.getIdade());
        usuario.setCpf(entity.getCpf());
        usuario.setIdade(entity.getIdade());
        return usuario;
    }
}
