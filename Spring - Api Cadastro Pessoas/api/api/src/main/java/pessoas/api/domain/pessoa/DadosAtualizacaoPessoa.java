package pessoas.api.domain.pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record DadosAtualizacaoPessoa(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        @CPF
        String cpf,
        @NotNull
        @PastOrPresent
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data_nascimento
        ) {
}
