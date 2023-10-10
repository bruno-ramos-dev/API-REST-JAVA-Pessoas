package com.attornatus.people.domain.pessoa;

import com.attornatus.people.domain.endereco.Endereco;

public record DadosDetalhamentoPessoa(
        Long id,
        String nome,
        String email,
        String telefone
) {

    public DadosDetalhamentoPessoa(Pessoa pessoa) {
        this(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getEmail(),
                pessoa.getTelefone()
        );
    }
}
