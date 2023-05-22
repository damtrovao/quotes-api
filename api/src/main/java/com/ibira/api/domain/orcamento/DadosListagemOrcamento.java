package com.ibira.api.domain.orcamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemOrcamento(Long id, String nomeCliente, LocalDate dataEntrega, BigDecimal valor, StatusOrcamento status) {
    public DadosListagemOrcamento(Orcamento orcamento) {
        this(orcamento.getId(), orcamento.getCliente().getNome(), orcamento.getDataEntrega(), orcamento.getValor(), orcamento.getStatus());
    }
}
