package tech.ada.rflima.b3testesexercicios.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tech.ada.rflima.b3testesexercicios.dto.UsuarioDTO;
import tech.ada.rflima.b3testesexercicios.service.CriarUsuarioService;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    static final String PATH = "/v1/usuarios";
    @InjectMocks
    UsuarioController usuarioController;

    @Mock
    CriarUsuarioService criarUsuarioService;

    MockMvc mockMvc;

    UsuarioDTO usuarioDTO;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
        usuarioDTO = new UsuarioDTO();
    }

    @Test
    void deveCriarUmUsuarioComSucessoStatusCode201() throws Exception {
        //Cenário
        usuarioDTO.setNome("Rodolfo");
        usuarioDTO.setCpf("04747103198");
        usuarioDTO.setIdade(30);

        //Ação e Verificação
        mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(usuarioDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                //validar retorno
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deveRetornarStatusCode400QuandoIdadeForNegativa() throws Exception {
        //Cenário
        usuarioDTO.setNome("Rodolfo");
        usuarioDTO.setCpf("04747103198");
        usuarioDTO.setIdade(-1);

        //Ação e Verificação
        mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(usuarioDTO)))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deveRetornarStatusCode400QuandoNomeForMenorQueTresCaracteres() throws Exception {
        //Cenário
        usuarioDTO.setNome("Ro");
        usuarioDTO.setCpf("04747103198");
        usuarioDTO.setIdade(30);

        //Ação e Verificação
        mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(usuarioDTO)))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deveRetornarStatusCode400QuandoNomeForQuandoCpfForForaDoPadrao() throws Exception {
        //Cenário
        usuarioDTO.setNome("Rodolfo");
        usuarioDTO.setCpf("0474710398");
        usuarioDTO.setIdade(30);

        //Ação e Verificação
        mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(usuarioDTO)))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print());
    }

    //método utilitário para transformar um objeto java em formato json
    private static String asJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}