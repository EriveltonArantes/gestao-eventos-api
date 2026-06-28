package com.gestaoeventosapi.dto;

import jakarta.validation.constraints.*;

public class InscricaoRequestDTO {

    @NotNull(message = "ParticipanteId é obrigatório")
    @Positive(message = "ParticipanteId deve ser um ID válido (positivo)")
    private Long participanteId;
    @NotNull(message = "EventoId é obrigatório")
    @Positive(message = "EventoId deve ser um ID válido (positivo)")
    private Long eventoId;
    @NotNull(message = "data inscricao não pode ser nulo")
    private java.time.LocalDateTime dataInscricao;
    @DecimalMin(value = "0.0", message = "valor não pode ser negativo")
    @NotNull(message = "valor não pode ser nulo")
    private java.math.BigDecimal valor;
    @NotBlank(message = "forma pagamento não pode estar em branco")
    private String formaPagamento;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
