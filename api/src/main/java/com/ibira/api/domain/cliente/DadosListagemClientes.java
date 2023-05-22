package com.ibira.api.domain.cliente;

public record DadosListagemClientes(Long id, String nome, String telefone) {
    public DadosListagemClientes(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getTelefone());
    }
}
