package br.com.routineapp;

import br.com.routineapp.application.repositories.HabitoRepository;
import br.com.routineapp.application.repositories.TarefaRepository;
import br.com.routineapp.application.usecases.CriarHabito;
import br.com.routineapp.application.usecases.CriarTarefa;
import br.com.routineapp.application.usecases.RegistrarExecucaoHabito;
import br.com.routineapp.domain.Habito;
import br.com.routineapp.domain.Tarefa;
import br.com.routineapp.infrastructure.controllers.RotinaController;
import br.com.routineapp.infrastructure.persistence.HabitoRepositoryImpl;
import br.com.routineapp.infrastructure.persistence.TarefaRepositoryImpl;

public class CleanRoutineAppDemoExpanded {
    public static void main(String[] args) {
        // 1. Configuração das dependências (Composition Root)
        TarefaRepository tarefaRepo = new TarefaRepositoryImpl();
        HabitoRepository habitoRepo = new HabitoRepositoryImpl();

        CriarTarefa criarTarefa = new CriarTarefa(tarefaRepo);
        CriarHabito criarHabito = new CriarHabito(habitoRepo);
        RegistrarExecucaoHabito registrarExecucao = new RegistrarExecucaoHabito(habitoRepo);

        RotinaController controller = new RotinaController(criarTarefa, criarHabito, registrarExecucao, tarefaRepo, habitoRepo);

        System.out.println("--- Iniciando Simulação do App de Rotina Pessoal ---");

        // 2. Simulação de Interação do Usuário
        System.out.println("\n>> Criando tarefas...");
        controller.criarNovaTarefa("Entregar relatório do projeto X", "Finalizar a análise de dados.", Tarefa.Prioridade.ALTA);
        controller.criarNovaTarefa("Comprar mantimentos", "Lista: Leite, pão, ovos.", Tarefa.Prioridade.MEDIA);

        System.out.println("\n>> Criando hábitos...");
        Habito habitoLeitura = controller.criarNovoHabito("Ler por 30 minutos", Habito.Frequencia.DIARIA);
        Habito habitoAgua = controller.criarNovoHabito("Beber 2L de água", Habito.Frequencia.DIARIA);

        System.out.println("\n--- Estado Atual da Rotina ---");
        System.out.println("Tarefas:");
        controller.listarTarefas().forEach(t -> System.out.printf("  - %s (Prioridade: %s)\n", t.getTitulo(), t.getPrioridade()));
        System.out.println("Hábitos:");
        controller.listarHabitos().forEach(h -> System.out.printf("  - %s (Check-ins: %d)\n", h.getTitulo(), h.getContagemExecucoes()));

        System.out.println("\n>> Registrando check-in no hábito de leitura...");
        controller.registrarCheckInHabito(habitoLeitura.getId());
        System.out.println(">> Registrando check-in no hábito de leitura mais uma vez...");
        controller.registrarCheckInHabito(habitoLeitura.getId());
        System.out.println(">> Registrando check-in no hábito de beber água...");
        controller.registrarCheckInHabito(habitoAgua.getId());

        System.out.println("\n--- Estado Final da Rotina ---");
        System.out.println("Tarefas:");
        controller.listarTarefas().forEach(t -> System.out.printf("  - %s (Prioridade: %s)\n", t.getTitulo(), t.getPrioridade()));
        System.out.println("Hábitos (após check-ins):");
        controller.listarHabitos().forEach(h -> System.out.printf("  - %s (Check-ins: %d)\n", h.getTitulo(), h.getContagemExecucoes()));

        System.out.println("\n--- Simulação Finalizada ---");
    }
}