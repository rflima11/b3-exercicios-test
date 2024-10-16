package tech.ada.rflima.b3testesexercicios.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.ada.rflima.b3testesexercicios.entity.Tarefa;

import java.util.List;

public class TodoServiceTest {

    //TDD - Test Driven Development
    // 3 - estágios - RED -> GREEN -> REFACTOR

    @Test
    void deveAdicionarUmaTarefaComSucesso() {
        //Cenário
        TodoService service = new TodoService();
        Tarefa tarefa = new Tarefa("Estudar TDD");

        //Ação
        service.adicionarTarefa(tarefa);

        //Verificação
        Assertions.assertEquals(1, service.listarTarefas().size());
        Assertions.assertEquals("Estudar TDD", service.listarTarefas().get(0).getTitulo());
    }

    @Test
    void deveLancarExcecaoAoRemoverUmaTarefaQueNaoExiste() {
        //Cenário
        TodoService service = new TodoService();
        String titulo = "Dar comida ao cachorro";
        Tarefa tarefa = new Tarefa(titulo);

        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> service.removerTarefa(tarefa));

        Assertions.assertEquals(String.format("Não existe a tarefa com o título %s na sua lista", titulo), runtimeException.getMessage());
    }

    @Test
    void deveLancarExcecaoCasoColoqueAMesmaTarefaDuasVezes() {
        //Cenário
        TodoService todoService = new TodoService();
        Tarefa tarefa = new Tarefa("Estudar TDD");
        Tarefa tarefaRepetida = new Tarefa("Estudar TDD");
        todoService.adicionarTarefa(tarefa);


        //Execução e Verificação
        Assertions.assertThrows(RuntimeException.class, () -> todoService.adicionarTarefa(tarefaRepetida));
    }

    @Test
    void deveLancarExcecaoAoTentarModificarListaDeTarefasDiretamente() {
        //Cenário
        TodoService service = new TodoService();
        Tarefa tarefa = new Tarefa("Levar o cachorro para passear");

        List<Tarefa> listaTarefas = service.listarTarefas();

        Assertions.assertThrows(Exception.class,  () -> listaTarefas.remove(tarefa));
    }

    @Test
    void deveRemoverUmaTarefaComSucesso() {
        //Cenário
        TodoService service = new TodoService();
        Tarefa tarefa = new Tarefa("Fazer exercícios");
        service.adicionarTarefa(tarefa);

        //Ação
        service.removerTarefa(tarefa);

        //Verificação
        Assertions.assertEquals(0, service.listarTarefas().size());
    }


    @Test
    void deveMarcarUmaTarefaConcluidaComSucesso() {
        //Cenário
        TodoService service = new TodoService();
        Tarefa tarefa = new Tarefa("Lavar louça");
        service.adicionarTarefa(tarefa);


        //Ação
        service.marcarComoConcluida(tarefa);


        //Verificação
        Assertions.assertTrue(service.listarTarefas().get(0).isConcluida());
    }

    @Test
    void deveLancarExcecaoCasoMarqueUmaTarefaComoConcluidaQueNaoExisteNaList() {
        //Cenário
        TodoService service = new TodoService();
        Tarefa tarefa = new Tarefa("Trabalhar 8h");

        //Ação
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> service.marcarComoConcluida(tarefa));

        Assertions.assertEquals(String.format("Tarefa %s não existe na lista para que seja marcada como concluida", tarefa.getTitulo()), exception.getMessage());
    }


}
