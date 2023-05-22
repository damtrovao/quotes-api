package com.ibira.api.domain.movel;

public record DadosAtualizacaoMovel(Long id, String nome, TipoDeMovel tipoMovel, TipoDePuxador tipoPuxador, TipoDeBase tipoBase,
                                    TipoDeTampo tipoTampo, int numeroDePortas, TipoDePorta tipoPorta, int numeroDeGavetas) {
}
