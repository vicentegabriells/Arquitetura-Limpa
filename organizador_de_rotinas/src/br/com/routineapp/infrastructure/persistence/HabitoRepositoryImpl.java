package br.com.routineapp.infrastructure.persistence;

import br.com.routineapp.application.repositories.HabitoRepository;
import br.com.routineapp.domain.Habito;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HabitoRepositoryImpl implements HabitoRepository {
    private final List<Habito> habitos = new ArrayList<>();

    @Override
    public void salvar(Habito habito) {
        habitos.removeIf(h -> h.getId().equals(habito.getId()));
        habitos.add(habito);
    }

    @Override
    public Optional<Habito> buscarPorId(Long id) {
        return habitos.stream().filter(h -> h.getId().equals(id)).findFirst();
    }

    @Override
    public List<Habito> listarTodos() {
        return new ArrayList<>(habitos);
    }
}