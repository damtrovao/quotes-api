package com.ibira.api.domain.movel;

public record DadosListagemMoveis (Long id, String nome, TipoDeMovel tipoMovel){
    public DadosListagemMoveis (Movel movel){
        this(movel.getId(), movel.getNome(), movel.getTipoMovel());
    }
}
