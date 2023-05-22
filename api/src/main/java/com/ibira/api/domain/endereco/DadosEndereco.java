package com.ibira.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String logradouro,

        @NotBlank
        String numero,

        String complemento,

        String bairro,

        String cidade,

        String uf,

        @Pattern(regexp = "\\d{8}")
        String cep

        ) {
}
