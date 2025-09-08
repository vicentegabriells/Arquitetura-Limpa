package br.com.routineapp.application.usecases;

import br.com.routineapp.application.repositories.HabitoRepository;
import br.com.routineapp.domain.Habito;

public class CriarHabito {
    private final HabitoRepository repository;

    public CriarHabito(HabitoRepository repository) {
        this.repository = repository;
    }

    public Habito executar(String titulo, Habito.Frequencia frequencia) {
        Habito novoHabito = new Habito(titulo, frequencia);
        repository.salvar(novoHabito);
        return novoHabito;
    }
}