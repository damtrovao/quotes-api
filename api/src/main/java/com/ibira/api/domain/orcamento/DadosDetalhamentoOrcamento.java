package com.ibira.api.domain.orcamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosDetalhamentoOrcamento(Long idOrcamento, String nomeCliente, LocalDate dataInicio,
                                         LocalDate dataEntrega, BigDecimal valor, StatusOrcamento status) {
    public DadosDetalhamentoOrcamento(Orcamento orcamento) {
        this(orcamento.getId(), orcamento.getCliente().getNome(), orcamento.getDataInicio(), orcamento.getDataEntrega(),
                orcamento.getValor(), orcamento.getStatus());
    }
}
