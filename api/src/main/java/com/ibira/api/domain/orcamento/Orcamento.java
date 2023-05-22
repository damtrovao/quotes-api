package com.ibira.api.domain.orcamento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibira.api.domain.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Orcamento")
@Table(name = "orcamentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Orcamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cliente cliente;

    private LocalDate dataInicio;

    private LocalDate dataEntrega;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusOrcamento status;

    private Boolean ativo;

    public void atualizarInformacoes(DadosAtualizacaoOrcamento dados) {
        if(dados.dataEntrega() != null){
            this.dataEntrega = dados.dataEntrega();
        }
        if(dados.valor() != null){
            this.valor = dados.valor();
        }
        if(dados.status() != null){
            this.status = dados.status();
        }
    }

    public void excluir() { this.ativo = false; }
}
