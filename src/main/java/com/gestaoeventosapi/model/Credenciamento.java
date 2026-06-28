package com.gestaoeventosapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "credenciamentos")
public class Credenciamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inscricao_id")
    private Inscricao inscricao;
    private java.time.LocalDateTime dataHoraEntrada;
    @Column(nullable = false)
    private String cracha;
    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Inscricao getInscricao() { return inscricao; }
    public void setInscricao(Inscricao inscricao) { this.inscricao = inscricao; }
    public java.time.LocalDateTime getDataHoraEntrada() { return dataHoraEntrada; }
    public void setDataHoraEntrada(java.time.LocalDateTime dataHoraEntrada) { this.dataHoraEntrada = dataHoraEntrada; }
    public String getCracha() { return cracha; }
    public void setCracha(String cracha) { this.cracha = cracha; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
