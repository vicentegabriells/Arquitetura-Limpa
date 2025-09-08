package br.com.routineapp.infrastructure.persistence;

import br.com.routineapp.application.repositories.TarefaRepository;
import br.com.routineapp.domain.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class TarefaRepositoryImpl implements TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();

    @Override
    public void salvar(Tarefa tarefa) {
        tarefas.removeIf(t -> t.getId().equals(tarefa.getId()));
        tarefas.add(tarefa);
    }

    @Override
    public List<Tarefa> listarTodas() {
        return new ArrayList<>(tarefas);
    }
}