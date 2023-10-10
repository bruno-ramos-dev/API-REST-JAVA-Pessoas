package com.attornatus.people.domain.pessoa;

import com.attornatus.people.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosEdicaoPessoa(
        @NotNull
        Long id,
        String nome,
        String telefone
) {
}
