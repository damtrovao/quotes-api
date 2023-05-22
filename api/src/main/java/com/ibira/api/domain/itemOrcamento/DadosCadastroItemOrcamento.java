package com.ibira.api.domain.itemOrcamento;

import com.ibira.api.domain.movel.TipoDeBase;
import com.ibira.api.domain.movel.TipoDePorta;
import com.ibira.api.domain.movel.TipoDePuxador;
import com.ibira.api.domain.movel.TipoDeTampo;

public record DadosCadastroItemOrcamento(Long id, Long idOrcamento, Long idMovel, String materialCorpo, String materialFrentes,
                                         int largura, int altura, int profundidade, TipoDePuxador tipoPuxador, TipoDePorta tipoPorta,
                                         int numeroDePortas, int numeroDeGavetas, TipoDeBase tipoBase, TipoDeTampo tipoTampo) {
}
