package com.ibira.api.domain.movel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Movel")
@Table(name = "moveis")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Movel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    @Enumerated(EnumType.STRING)
    TipoDeMovel tipoMovel;

    @Enumerated(EnumType.STRING)
    TipoDePuxador tipoPuxador;

    @Enumerated(EnumType.STRING)
    TipoDeBase tipoBase;

    @Enumerated(EnumType.STRING)
    TipoDeTampo tipoTampo;

    @Column(name = "numero_portas")
    int numeroDePortas;

    @Enumerated(EnumType.STRING)
    TipoDePorta tipoPorta;

    @Column(name = "numero_gavetas")
    int numeroDeGavetas;

    Boolean ativo;

    public Movel(DadosCadastroMovel dados) {
        this.nome = dados.nome();
        this.tipoMovel = dados.tipoMovel();
        this.tipoPuxador = dados.tipoPuxador();
        this.tipoBase = dados.tipoBase();
        this.tipoTampo = dados.tipoTampo();
        this.numeroDePortas = dados.numeroDePortas();
        this.tipoPorta = dados.tipoPorta();
        this.numeroDeGavetas = dados.numeroDeGavetas();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoMovel dados) {
        if(dados.id() != null) {
            this.id = dados.id();
        }
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.tipoMovel() != null) {
            this.tipoMovel = dados.tipoMovel();
        }
        if(dados.tipoPuxador() != null) {
            this.tipoPuxador = dados.tipoPuxador();
        }
        if(dados.tipoBase() != null) {
            this.tipoBase = dados.tipoBase();
        }
        if(dados.tipoTampo() != null) {
            this.tipoTampo = dados.tipoTampo();
        }

        this.numeroDePortas = dados.numeroDePortas();

        if(dados.tipoPorta() != null) {
            this.tipoPorta = dados.tipoPorta();
        }

        this.numeroDeGavetas = dados.numeroDeGavetas();
    }

    public void excluir(Movel movel) {  this.ativo = false;  }
}
