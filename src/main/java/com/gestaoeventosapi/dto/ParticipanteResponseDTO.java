package com.gestaoeventosapi.dto;

public class ParticipanteResponseDTO {

    private Long id;
    private Long eventoId;
    private Long credenciamentoId;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String empresa;
    private String cargo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
