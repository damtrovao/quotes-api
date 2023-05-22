package com.ibira.api.domain.cliente;

import com.ibira.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
        @NotBlank
        String nome,

        @Email
        String email,

        String telefone,

        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
