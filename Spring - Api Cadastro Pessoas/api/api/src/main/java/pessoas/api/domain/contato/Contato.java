package pessoas.api.domain.contato;

import jakarta.persistence.*;
import lombok.*;
import pessoas.api.domain.pessoa.Pessoa;


@Table(name = "contatos")
@Entity(name = "Contato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;


    public Contato(DadosContato dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
    }


}

