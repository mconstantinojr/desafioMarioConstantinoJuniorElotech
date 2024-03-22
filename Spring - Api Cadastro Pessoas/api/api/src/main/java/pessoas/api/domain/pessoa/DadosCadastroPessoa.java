package pessoas.api.domain.pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.br.CPF;
import pessoas.api.domain.contato.Contato;

import java.time.LocalDate;
import java.util.List;


public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        @NotBlank
        @CPF
        String cpf,
        @NotNull
        @PastOrPresent
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data_nascimento,
        @NotNull
        @Valid
        List<Contato> listaContato

        ) {
}
