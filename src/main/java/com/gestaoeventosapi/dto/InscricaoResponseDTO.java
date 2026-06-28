package com.gestaoeventosapi.dto;

public class InscricaoResponseDTO {

    private Long id;
    private Long participanteId;
    private Long eventoId;
    private java.time.LocalDateTime dataInscricao;
    private java.math.BigDecimal valor;
    private String formaPagamento;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getParticipanteId() { return participanteId; }
    public void setParticipanteId(Long participanteId) { this.participanteId = participanteId; }
    public Long getEventoId() { return eventoId; }
    public void setEventoId(Long eventoId) { this.eventoId = eventoId; }
    public java.time.LocalDateTime getDataInscricao() { return dataInscricao; }
    public void setDataInscricao(java.time.LocalDateTime dataInscricao) { this.dataInscricao = dataInscricao; }
    public java.math.BigDecimal getValor() { return valor; }
    public void setValor(java.math.BigDecimal valor) { this.valor = valor; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
