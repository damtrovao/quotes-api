package com.ibira.api.domain.cliente;

import com.ibira.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(

        @NotNull
        Long id,

        String nome,

        String email,

        String telefone,

        DadosEndereco endereco
) {
}
