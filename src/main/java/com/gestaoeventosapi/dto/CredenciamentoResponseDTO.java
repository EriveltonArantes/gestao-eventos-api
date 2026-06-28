package com.gestaoeventosapi.dto;

public class CredenciamentoResponseDTO {

    private Long id;
    private Long inscricaoId;
    private java.time.LocalDateTime dataHoraEntrada;
    private String cracha;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInscricaoId() { return inscricaoId; }
    public void setInscricaoId(Long inscricaoId) { this.inscricaoId = inscricaoId; }
    public java.time.LocalDateTime getDataHoraEntrada() { return dataHoraEntrada; }
    public void setDataHoraEntrada(java.time.LocalDateTime dataHoraEntrada) { this.dataHoraEntrada = dataHoraEntrada; }
    public String getCracha() { return cracha; }
    public void setCracha(String cracha) { this.cracha = cracha; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
