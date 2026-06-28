package com.gestaoeventosapi.dto;

import jakarta.validation.constraints.*;

public class EventoRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotBlank(message = "local não pode estar em branco")
    private String local;
    @FutureOrPresent(message = "data inicio não pode ser retroativo")
    @NotNull(message = "data inicio não pode ser nulo")
    private java.time.LocalDateTime dataInicio;
    @FutureOrPresent(message = "data fim não pode ser retroativo")
    @NotNull(message = "data fim não pode ser nulo")
    private java.time.LocalDateTime dataFim;
    @Min(value = 0, message = "capacidade não pode ser negativo")
    @NotNull(message = "capacidade não pode ser nulo")
    private Integer capacidade;
    @DecimalMin(value = "0.0", message = "preco não pode ser negativo")
    @NotNull(message = "preco não pode ser nulo")
    private java.math.BigDecimal preco;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
    public java.time.LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(java.time.LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public java.time.LocalDateTime getDataFim() { return dataFim; }
    public void setDataFim(java.time.LocalDateTime dataFim) { this.dataFim = dataFim; }
    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }
    public java.math.BigDecimal getPreco() { return preco; }
    public void setPreco(java.math.BigDecimal preco) { this.preco = preco; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
