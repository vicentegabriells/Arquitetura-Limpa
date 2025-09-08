package br.com.routineapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Habito {
    private final Long id;
    private final String titulo;
    private final Frequencia frequencia;
    private final List<LocalDate> execucoes;

    public enum Frequencia { DIARIA, SEMANAL }

    public Habito(String titulo, Frequencia frequencia) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título do hábito não pode ser vazio.");
        }
        this.id = System.nanoTime(); // ID único
        this.titulo = titulo;
        this.frequencia = frequencia;
        this.execucoes = new ArrayList<>();
    }

    public void registrarExecucao() {
        this.execucoes.add(LocalDate.now());
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public Frequencia getFrequencia() { return frequencia; }
    public List<LocalDate> getExecucoes() { return new ArrayList<>(execucoes); }
    public int getContagemExecucoes() { return this.execucoes.size(); }
}