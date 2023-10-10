package com.attornatus.people.domain.pessoa;

import com.attornatus.people.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;

    public Pessoa(DadosCriacaoPessoa dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }

    public void atualizarInformacoes(DadosEdicaoPessoa dados) {

        if (dados.nome() != null && !dados.nome().trim().isEmpty()) {
            this.nome = dados.nome();
        }

        if (dados.telefone() != null && !dados.telefone().trim().isEmpty()) {
            this.telefone = dados.telefone();
        }

    }
}
