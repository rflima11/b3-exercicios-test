package tech.ada.rflima.b3testesexercicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.rflima.b3testesexercicios.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);

}
