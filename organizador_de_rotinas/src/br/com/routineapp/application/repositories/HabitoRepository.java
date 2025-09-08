package br.com.routineapp.application.repositories;

import br.com.routineapp.domain.Habito;
import java.util.List;
import java.util.Optional;

public interface HabitoRepository {
    void salvar(Habito habito);
    Optional<Habito> buscarPorId(Long id);
    List<Habito> listarTodos();
}