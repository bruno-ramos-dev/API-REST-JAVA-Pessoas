package com.attornatus.people.domain.pessoa;

import com.attornatus.people.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCriacaoPessoa(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank(message = "{telefone.obrigatorio}")
        @Pattern(regexp = "\\(?\\d{2}\\)?\\d{4,5}\\-?\\d{4}")
        String telefone
) {
}
