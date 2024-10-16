package tech.ada.rflima.b3testesexercicios.entity;

public class Tarefa {

    private String titulo;
    private boolean concluida;

    public Tarefa(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarConcluida() {
        this.concluida = true;
    }
}
