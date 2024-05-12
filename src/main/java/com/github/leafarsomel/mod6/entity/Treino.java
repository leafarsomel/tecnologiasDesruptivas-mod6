package com.github.leafarsomel.mod6.entity;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "treinos")
public class Treino {
    // ID único para identificar o treino
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treino_id")
    private Integer treinoId;

    // Início do treino
    @Column(name = "treino_inicio")
    private LocalDateTime treinoInicio;

    // Series realizadas durante o treino
    @Column(name = "treino_series")
    private Integer treinoSeries;

    // Final do treino
    @Column(name = "treino_final")
    private LocalDateTime treinoFinal;

    // Local do treino
    @Column(name = "treino_local")
    private String treinoLocal;

    public void setTreinoId(Integer treinoId) {
        this.treinoId = treinoId;
    }

    public Integer getTreinoId() {
        return treinoId;
    }

    public void setTreinoInicio(LocalDateTime treinoInicio) {
        this.treinoInicio = treinoInicio;
    }

    public LocalDateTime getTreinoInicio() {
        return treinoInicio;
    }

    public void setTreinoSeries(Integer treinoSeries) {
        this.treinoSeries = treinoSeries;
    }

    public Integer getTreinoSeries() {
        return treinoSeries;
    }

    public void setTreinoFinal(LocalDateTime treinoFinal) {
        this.treinoFinal = treinoFinal;
    }

    public LocalDateTime getTreinoFinal() {
        return treinoFinal;
    }

    public void setTreinoLocal(String treinoLocal) {
        this.treinoLocal = treinoLocal;
    }

    public String getTreinoLocal() {
        return treinoLocal;
    }

    // Retorna a duração do treino
    public Long getTreinoDuracao() {
        Duration duracao = Duration.between(treinoInicio, treinoFinal);
        return duracao.toMinutes();
    }
}
