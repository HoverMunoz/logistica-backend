package com.logistica.infrastructure.adapter.in;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.logistica.domain.model.Envio;
import com.logistica.domain.port.in.EnvioUseCase;
import com.logistica.infrastructure.adapter.in.controller.EnvioController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = EnvioController.class,
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {
                        com.logistica.infrastructure.security.JwtFilter.class
                }
        )
)
@AutoConfigureMockMvc(addFilters = false) // 🔥 desactiva filtros de seguridad
class EnvioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EnvioUseCase envioUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deberiaListarEnvios() throws Exception {

        Envio envio = new Envio();
        envio.setId(1L);
        envio.setTipoLogistica("TERRESTRE");
        envio.setCantidad(5);

        when(envioUseCase.listar()).thenReturn(List.of(envio));

        mockMvc.perform(get("/api/envios"))
                .andExpect(status().isOk());
    }
}
