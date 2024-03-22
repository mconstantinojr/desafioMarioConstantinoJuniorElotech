package pessoas.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pessoas.api.domain.pessoa.DadosDetalhamentoPessoa;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class PessoaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosDetalhamentoPessoa> dadosDetalhamentoPessoaJson;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    void listar_cenario1() throws Exception {
        var response = mvc.perform(post("/pessoas")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validar")
    void listar_cenario2() throws Exception {
        var data = LocalDate.now();

        var response = mvc
                .perform(post("/pessoas/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosDetalhamentoPessoaJson.write(new DadosDetalhamentoPessoa(2L,"Jorge", "01111111111", data)
                        ).getJson())
                )
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = dadosDetalhamentoPessoaJson.write(
                new DadosDetalhamentoPessoa(2L,"Jorge", "01111111111", data)).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}

