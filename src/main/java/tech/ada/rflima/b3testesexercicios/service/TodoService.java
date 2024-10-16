package tech.ada.rflima.b3testesexercicios.service;

import tech.ada.rflima.b3testesexercicios.entity.Tarefa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoService {

    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {

        boolean tarefaJaExiste = verificarTarefaExistente(tarefa);

        if (tarefaJaExiste) {
            throw new RuntimeException("Tarefa já existe");
        }

        tarefas.add(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return Collections.unmodifiableList(tarefas);
    }

    public void removerTarefa(Tarefa tarefa) {
        boolean tarefaJaExiste = verificarTarefaExistente(tarefa);

        if (!tarefaJaExiste) {
            throw new RuntimeException(String.format("Não existe a tarefa com o título %s na sua lista", tarefa.getTitulo()));
        }

        tarefas.remove(tarefa);
    }

    public void marcarComoConcluida(Tarefa tarefa) {
        boolean tarefaExistente = verificarTarefaExistente(tarefa);

        if (!tarefaExistente) {
            throw new RuntimeException(String.format("Tarefa %s não existe na lista para que seja marcada como concluida", tarefa.getTitulo()));
        }

        tarefa.marcarConcluida();
    }

    private boolean verificarTarefaExistente(Tarefa tarefa) {
        return tarefas.stream()
                .anyMatch(t -> t.getTitulo().equalsIgnoreCase(tarefa.getTitulo()));
    }
}
