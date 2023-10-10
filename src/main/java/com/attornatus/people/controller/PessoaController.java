package com.attornatus.people.controller;

import com.attornatus.people.domain.pessoa.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosCriacaoPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoa(dados);
        repository.save(pessoa);

        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));

    }

    @PutMapping
    @Transactional
    public ResponseEntity editar(@RequestBody @Valid DadosEdicaoPessoa dados) {
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity consultar(@PathVariable Long id) {
        var pessoa = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }
}
