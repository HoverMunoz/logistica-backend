package com.logistica.application.service;

import com.logistica.domain.model.Envio;
import com.logistica.domain.port.out.EnvioRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnvioServiceTest {

    @Mock
    private EnvioRepositoryPort repository;

    @InjectMocks
    private EnvioService service;

    private Envio envio;

    @BeforeEach
    void setUp() {
        envio = new Envio(
                1L,
                "TERRESTRE",
                "Electrónica",
                15,
                LocalDate.now(),
                LocalDate.now().plusDays(3),
                new BigDecimal("1000"),
                new BigDecimal("950"),
                "AB12345678",
                "ABC123",
                null,
                1L,
                "Pendiente",
                "Bodega Central",
                null
        );
    }

    @Test
    void deberiaCrearEnvio() {

        when(repository.guardar(any())).thenReturn(envio);

        Envio resultado = service.crear(envio);

        assertNotNull(resultado);
        assertEquals("TERRESTRE", resultado.getTipoLogistica());

        verify(repository, times(1)).guardar(any());
    }

    @Test
    void deberiaListarEnvios() {

        when(repository.obtenerTodos()).thenReturn(List.of(envio));

        List<Envio> lista = service.listar();

        assertEquals(1, lista.size());
        verify(repository).obtenerTodos();
    }

    @Test
    void deberiaObtenerPorId() {

        when(repository.obtenerPorId(1L)).thenReturn(Optional.of(envio));

        Envio resultado = service.obtener(1L);

        assertEquals(1L, resultado.getId());
    }

    @Test
    void deberiaEliminarEnvio() {

        doNothing().when(repository).eliminar(1L);

        service.eliminar(1L);

        verify(repository, times(1)).eliminar(1L);
    }
}
