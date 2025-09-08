package br.com.routineapp.infrastructure.controllers;

import br.com.routineapp.application.repositories.HabitoRepository;
import br.com.routineapp.application.repositories.TarefaRepository;
import br.com.routineapp.application.usecases.CriarHabito;
import br.com.routineapp.application.usecases.CriarTarefa;
import br.com.routineapp.application.usecases.RegistrarExecucaoHabito;
import br.com.routineapp.domain.Habito;
import br.com.routineapp.domain.Tarefa;
import java.util.List;

public class RotinaController {
    private final CriarTarefa criarTarefaUseCase;
    private final CriarHabito criarHabitoUseCase;
    private final RegistrarExecucaoHabito registrarExecucaoHabitoUseCase;
    private final TarefaRepository tarefaRepository;
    private final HabitoRepository habitoRepository;

    public RotinaController(CriarTarefa ct, CriarHabito ch, RegistrarExecucaoHabito reh, TarefaRepository tr, HabitoRepository hr) {
        this.criarTarefaUseCase = ct;
        this.criarHabitoUseCase = ch;
        this.registrarExecucaoHabitoUseCase = reh;
        this.tarefaRepository = tr;
        this.habitoRepository = hr;
    }

    public Tarefa criarNovaTarefa(String t, String d, Tarefa.Prioridade p) {
        return criarTarefaUseCase.executar(t, d, p);
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.listarTodas();
    }

    public Habito criarNovoHabito(String t, Habito.Frequencia f) {
        return criarHabitoUseCase.executar(t, f);
    }

    public void registrarCheckInHabito(Long id) {
        registrarExecucaoHabitoUseCase.executar(id);
    }

    public List<Habito> listarHabitos() {
        return habitoRepository.listarTodos();
    }
}