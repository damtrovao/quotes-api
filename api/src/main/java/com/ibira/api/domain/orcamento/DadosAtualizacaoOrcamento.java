package com.ibira.api.domain.orcamento;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


public record DadosAtualizacaoOrcamento(
        @NotNull
        Long id,
        LocalDate dataEntrega,
        BigDecimal valor,
        StatusOrcamento status
    ) {

}
