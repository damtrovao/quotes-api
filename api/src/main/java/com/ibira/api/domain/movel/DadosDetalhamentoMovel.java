package com.ibira.api.domain.movel;

public record DadosDetalhamentoMovel(Long id, String nome, TipoDeMovel tipoMovel, TipoDePuxador tipoPuxador,
                                     TipoDeBase tipobase, TipoDeTampo tipoTampo, int numeroDePortas, TipoDePorta tipoPorta,
                                     int numeroDeGavetas) {
    public DadosDetalhamentoMovel (Movel movel){
        this(movel.getId(), movel.getNome(), movel.getTipoMovel(), movel.getTipoPuxador(), movel.getTipoBase(),
                movel.getTipoTampo(), movel.getNumeroDePortas(), movel.getTipoPorta(), movel.getNumeroDeGavetas());
    }
}
