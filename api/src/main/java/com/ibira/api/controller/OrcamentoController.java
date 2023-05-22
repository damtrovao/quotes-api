package com.ibira.api.controller;

import com.ibira.api.domain.cliente.ClienteRepository;
import com.ibira.api.domain.orcamento.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroOrcamento dados, UriComponentsBuilder uriBuilder) {

        var cliente = clienteRepository.getReferenceById(dados.idCliente());

        Orcamento orcamento = new Orcamento(null, cliente, dados.dataInicio(), dados.dataentrega(), dados.valor(), StatusOrcamento.CALCULANDO, true);
        orcamentoRepository.save(orcamento);

        var uri = uriBuilder.path("/orcamentos/{id}").buildAndExpand(orcamento.getId()).toUri();

        return ResponseEntity.created(uri).body(orcamento);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemOrcamento>> listar(@PageableDefault(size = 20, sort = {"cliente.nome"})Pageable paginacao) {
        var page = orcamentoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemOrcamento :: new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var orcamento = orcamentoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoOrcamento(orcamento));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoOrcamento dados) {
        var orcamento = orcamentoRepository.getReferenceById(dados.id());
        orcamento.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoOrcamento(orcamento));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var orcamento = orcamentoRepository.getReferenceById(id);
        orcamento.excluir();
        return ResponseEntity.noContent().build();

    }
}
