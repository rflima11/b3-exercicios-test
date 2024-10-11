package tech.ada.rflima.b3testesexercicios.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name= "CPF", unique = true)
    private String cpf;

    @Column(name = "IDADE")
    private int idade;

    @Column(name = "DATA_HORA_CRIACAO")
    private LocalDateTime dataHoraCriacao;

    public Usuario() {
    }

    public Usuario(String nome, String cpf, int idade, LocalDateTime dataHoraCriacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }
}
