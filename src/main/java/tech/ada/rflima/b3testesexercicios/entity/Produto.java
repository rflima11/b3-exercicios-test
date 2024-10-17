package tech.ada.rflima.b3testesexercicios.entity;

public class Produto {

    private String nome;
    private Double valor;

    public Produto(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return valor;
    }
}
