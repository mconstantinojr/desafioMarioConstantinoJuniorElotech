package pessoas.api.domain.contato;

import org.springframework.data.jpa.repository.JpaRepository;
import pessoas.api.domain.pessoa.Pessoa;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    List<Contato> findAllByPessoa_id(Long id);
}
