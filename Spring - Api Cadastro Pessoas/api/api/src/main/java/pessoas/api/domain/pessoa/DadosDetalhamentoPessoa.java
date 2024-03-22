package pessoas.api.domain.pessoa;

import java.time.LocalDate;

public record DadosDetalhamentoPessoa(Long id, String nome, String cpf, LocalDate data_nascimento) {

    public DadosDetalhamentoPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(),pessoa.getCpf(), pessoa.getData_nascimento());
    }
}
