package pessoas.api.domain.contato;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosContato(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email
        ) {
}
