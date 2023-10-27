package com.attornatus.people.domain.pessoa;

public record DadosListagemPessoa(
        Long id,
        String nome,
        String email,
        String telefone
) {

    public DadosListagemPessoa(Pessoa pessoa) {
        this(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getEmail(),
                pessoa.getTelefone()
        );
    }
}
