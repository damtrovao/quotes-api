package com.ibira.api.controller;

import com.ibira.api.domain.itemOrcamento.DadosCadastroItemOrcamento;
import com.ibira.api.domain.itemOrcamento.ItemOrcamento;
import com.ibira.api.domain.itemOrcamento.ItemOrcamentoRepository;
import com.ibira.api.domain.movel.MovelRepository;
import com.ibira.api.domain.orcamento.OrcamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/itensOrcamento")
public class ItemOrcamentoController {
    @Autowired
    private ItemOrcamentoRepository itemRepository;

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private MovelRepository movelRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroItemOrcamento dados, UriComponentsBuilder uriBuilder) {
        var orcamento = orcamentoRepository.getReferenceById(dados.idOrcamento());
        var movel = movelRepository.getReferenceById(dados.idMovel());
        ItemOrcamento itemOrcamento = new ItemOrcamento(null, orcamento, movel, dados.materialCorpo(), dados.materialFrentes(),
                dados.largura(), dados.altura(), dados.profundidade(), dados.tipoPuxador(), dados.tipoPorta(), dados.numeroDePortas(),
                dados.numeroDeGavetas(), dados.tipoBase(), dados.tipoTampo());

        itemRepository.save(itemOrcamento);

        var uri = uriBuilder.path("/itensOrcamento/{id}").buildAndExpand(itemOrcamento.getId()).toUri();

        return ResponseEntity.created(uri).body(itemOrcamento);
    }
}
