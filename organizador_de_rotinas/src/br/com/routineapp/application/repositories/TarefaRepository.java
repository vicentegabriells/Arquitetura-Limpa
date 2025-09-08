package br.com.routineapp.application.repositories;

import br.com.routineapp.domain.Tarefa;
import java.util.List;

public interface TarefaRepository {
    void salvar(Tarefa tarefa);
    List<Tarefa> listarTodas();
}