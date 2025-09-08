package br.com.routineapp.application.usecases;

import br.com.routineapp.application.repositories.HabitoRepository;
import br.com.routineapp.domain.Habito;
import java.util.Optional;

public class RegistrarExecucaoHabito {
    private final HabitoRepository repository;

    public RegistrarExecucaoHabito(HabitoRepository repository) {
        this.repository = repository;
    }

    public Optional<Habito> executar(Long habitoId) {
        Optional<Habito> habitoOpt = repository.buscarPorId(habitoId);
        habitoOpt.ifPresent(habito -> {
            habito.registrarExecucao();
            repository.salvar(habito);
        });
        return habitoOpt;
    }
}