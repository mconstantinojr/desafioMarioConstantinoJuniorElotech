package pessoas.api.domain.pessoa;

import java.time.LocalDate;

public record DadosListagemPessoa(Long id, String nome, String cpf, LocalDate data_nascimento) {

    public DadosListagemPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getData_nascimento());
    }
}
