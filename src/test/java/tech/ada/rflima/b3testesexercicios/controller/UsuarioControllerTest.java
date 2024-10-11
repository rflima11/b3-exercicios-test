package tech.ada.rflima.b3testesexercicios.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    @Test
    void deveCriarUmUsuarioComSucessoStatusCode201() throws Exception {

    }

    @Test
    void deveRetornarStatusCode400QuandoIdadeForNegativa() throws Exception {

    }

    @Test
    void deveRetornarStatusCode400QuandoNomeForMenorQueTresCaracteres() throws Exception {

    }

    @Test
    void deveRetornarStatusCode400QuandoNomeForQuandoCpfForForaDoPadrao() throws Exception {

    }

    private static String asJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}