package pessoas.api.domain.pessoa;

import jakarta.persistence.*;
import lombok.*;
import pessoas.api.domain.contato.Contato;
import pessoas.api.domain.contato.DadosContato;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate data_nascimento;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Contato> listaContato;

    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.data_nascimento = dados.data_nascimento();
        //var pessoaIn = new Pessoa(dados.nome(), dados.cpf(), dados.data_nascimento());
        //List<Contato> contatos = new ArrayList<>();
        //for (Contato contatoIn : dados.listaContato()) {
        //    var dadosContato = new DadosContato(contatoIn.getNome(), contatoIn.getTelefone(), contatoIn.getEmail());
        //    var contato = new Contato(dadosContato);
        //    contato.setPessoa(pessoaIn);
        //    contatos.add(contato);
        //}
        //this.listaContato = dados.listaContato();
        //pessoaIn.listaContato = contatos;
    }

    public Pessoa(String nome, String cpf, LocalDate data_nascimento) {
        this.nome =  nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
    }

    public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }

        if (dados.data_nascimento() != null) {
            this.data_nascimento = dados.data_nascimento();
        }
    }

}
