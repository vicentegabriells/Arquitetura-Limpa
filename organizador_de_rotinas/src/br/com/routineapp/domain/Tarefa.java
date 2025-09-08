package br.com.routineapp.domain;

public class Tarefa {
    private final Long id;
    private final String titulo;
    private final Prioridade prioridade;
    private boolean concluida;

    public enum Prioridade { ALTA, MEDIA, BAIXA }

    public Tarefa(String titulo, String descricao, Prioridade prioridade) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título da tarefa não pode ser vazio.");
        }
        this.id = System.nanoTime(); // ID único
        this.titulo = titulo;
        this.prioridade = prioridade;
        this.concluida = false;
    }

    public void marcarComoConcluida() { this.concluida = true; }
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public Prioridade getPrioridade() { return prioridade; }
    public boolean isConcluida() { return concluida; }
}