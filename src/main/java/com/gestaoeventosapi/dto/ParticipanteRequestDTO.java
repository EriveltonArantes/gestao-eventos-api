package com.gestaoeventosapi.dto;

import jakarta.validation.constraints.*;

public class ParticipanteRequestDTO {

    @NotNull(message = "EventoId é obrigatório")
    @Positive(message = "EventoId deve ser um ID válido (positivo)")
    private Long eventoId;
    @NotNull(message = "CredenciamentoId é obrigatório")
    @Positive(message = "CredenciamentoId deve ser um ID válido (positivo)")
    private Long credenciamentoId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "empresa não pode estar em branco")
    private String empresa;
    @NotBlank(message = "cargo não pode estar em branco")
    private String cargo;

    public Long getEventoId() { return eventoId; }
    public void setEventoId(Long eventoId) { this.eventoId = eventoId; }
    public Long getCredenciamentoId() { return credenciamentoId; }
    public void setCredenciamentoId(Long credenciamentoId) { this.credenciamentoId = credenciamentoId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}
