package com.ibira.api.domain.itemOrcamento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibira.api.domain.movel.*;
import com.ibira.api.domain.orcamento.Orcamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "ItemOrcamento")
@Table(name = "itens_orcamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orcamento")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Orcamento orcamento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movel")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Movel movel;

    String materialCorpo;
    String materialFrentes;
    int largura;
    int altura;
    int profundidade;

    @Enumerated
    TipoDePuxador tipoPuxador;

    @Enumerated
    TipoDePorta tipoPorta;

    @Column(name = "numero_portas")
    int numeroDePortas;

    @Column(name = "numero_gavetas")
    int numeroDeGavetas;

    @Enumerated
    TipoDeBase tipoBase;

    @Enumerated
    TipoDeTampo tipoTampo;

}
