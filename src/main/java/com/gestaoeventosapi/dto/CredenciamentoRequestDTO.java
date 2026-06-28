package com.gestaoeventosapi.dto;

import jakarta.validation.constraints.*;

public class CredenciamentoRequestDTO {

    @NotNull(message = "InscricaoId é obrigatório")
    @Positive(message = "InscricaoId deve ser um ID válido (positivo)")
    private Long inscricaoId;
    @FutureOrPresent(message = "data hora entrada não pode ser retroativo")
    @NotNull(message = "data hora entrada não pode ser nulo")
    private java.time.LocalDateTime dataHoraEntrada;
    @NotBlank(message = "cracha não pode estar em branco")
    private String cracha;

    private String observacoes;

    public Long getInscricaoId() { return inscricaoId; }
    public void setInscricaoId(Long inscricaoId) { this.inscricaoId = inscricaoId; }
    public java.time.LocalDateTime getDataHoraEntrada() { return dataHoraEntrada; }
    public void setDataHoraEntrada(java.time.LocalDateTime dataHoraEntrada) { this.dataHoraEntrada = dataHoraEntrada; }
    public String getCracha() { return cracha; }
    public void setCracha(String cracha) { this.cracha = cracha; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
