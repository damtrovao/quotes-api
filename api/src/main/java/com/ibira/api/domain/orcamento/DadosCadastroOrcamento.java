package com.ibira.api.domain.orcamento;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroOrcamento(

        @NotNull
        Long idCliente,

        @NotNull
        @DateTimeFormat
        LocalDate dataInicio,

        @DateTimeFormat
        LocalDate dataentrega,

        BigDecimal valor

) {
}
