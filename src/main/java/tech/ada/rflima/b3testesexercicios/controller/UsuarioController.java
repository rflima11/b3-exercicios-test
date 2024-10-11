package tech.ada.rflima.b3testesexercicios.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.rflima.b3testesexercicios.dto.UsuarioDTO;
import tech.ada.rflima.b3testesexercicios.entity.Usuario;
import tech.ada.rflima.b3testesexercicios.service.CriarUsuarioService;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    private final CriarUsuarioService criarUsuarioService;

    public UsuarioController(CriarUsuarioService criarUsuarioService) {
        this.criarUsuarioService = criarUsuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = criarUsuarioService.criarUsuario(usuarioDTO.getNome(), usuarioDTO.getIdade(), usuarioDTO.getCpf());
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}
