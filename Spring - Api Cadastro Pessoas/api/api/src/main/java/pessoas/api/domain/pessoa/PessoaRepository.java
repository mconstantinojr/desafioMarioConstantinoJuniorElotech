package pessoas.api.domain.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import pessoas.api.domain.contato.Contato;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
