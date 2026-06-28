package com.gestaoeventosapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inscricoes")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    private java.time.LocalDateTime dataInscricao;
    private java.math.BigDecimal valor;
    @Column(nullable = false)
    private String formaPagamento;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Participante getParticipante() { return participante; }
    public void setParticipante(Participante participante) { this.participante = participante; }
    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }
    public java.time.LocalDateTime getDataInscricao() { return dataInscricao; }
    public void setDataInscricao(java.time.LocalDateTime dataInscricao) { this.dataInscricao = dataInscricao; }
    public java.math.BigDecimal getValor() { return valor; }
    public void setValor(java.math.BigDecimal valor) { this.valor = valor; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
