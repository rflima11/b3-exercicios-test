package tech.ada.rflima.b3testesexercicios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class UsuarioDTO {

    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(min = 3, message = "Nome não pode possuir menos de três caracteres")
    private String nome;

    @Positive(message = "Idade não pode ser negativa")
    private int idade;

    @CPF(message = "CPF está fora do padrão válido.")
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
