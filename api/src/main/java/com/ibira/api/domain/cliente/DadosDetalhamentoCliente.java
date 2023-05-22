package com.ibira.api.domain.cliente;

import com.ibira.api.domain.endereco.Endereco;

public record DadosDetalhamentoCliente(Long id, String nome, String email, String telefone, Endereco endereco) {

    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco());
    }
}
