package br.com.routineapp.application.usecases;

import br.com.routineapp.application.repositories.TarefaRepository;
import br.com.routineapp.domain.Tarefa;

public class CriarTarefa {
    private final TarefaRepository repository;

    public CriarTarefa(TarefaRepository repository) {
        this.repository = repository;
    }

    public Tarefa executar(String titulo, String descricao, Tarefa.Prioridade prioridade) {
        Tarefa novaTarefa = new Tarefa(titulo, descricao, prioridade);
        repository.salvar(novaTarefa);
        return novaTarefa;
    }
}