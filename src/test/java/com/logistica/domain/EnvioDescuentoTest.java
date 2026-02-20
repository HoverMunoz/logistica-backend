package com.logistica.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EnvioDescuentoTest {

    @Test
    void deberiaAplicarDescuentoTerrestre() {

        BigDecimal precio = new BigDecimal("1000");
        BigDecimal descuento = precio.multiply(new BigDecimal("0.05"));
        BigDecimal resultado = precio.subtract(descuento);

        assertEquals(new BigDecimal("950.00"), resultado.setScale(2));
    }

    @Test
    void deberiaAplicarDescuentoMaritimo() {

        BigDecimal precio = new BigDecimal("1000");
        BigDecimal descuento = precio.multiply(new BigDecimal("0.03"));
        BigDecimal resultado = precio.subtract(descuento);

        assertEquals(new BigDecimal("970.00"), resultado.setScale(2));
    }
}
