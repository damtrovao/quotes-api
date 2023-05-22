package com.ibira.api.controller;

import com.ibira.api.domain.movel.*;
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
@RequestMapping("/moveis")
public class MovelController {

    @Autowired
    private MovelRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMovel dados, UriComponentsBuilder uriBuilder) {
        Movel movel = new Movel(dados);
        repository.save(movel);

        var uri = uriBuilder.path("/moveis/{id}").buildAndExpand(movel.getId()).toUri();

        return ResponseEntity.created(uri).body(movel);

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMoveis>> listar (@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMoveis::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMovel dados) {
        var movel = repository.getReferenceById(dados.id());
        movel.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMovel(movel));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var movel = repository.getReferenceById(id);
        movel.excluir(movel);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var movel = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoMovel(movel));
    }
}
