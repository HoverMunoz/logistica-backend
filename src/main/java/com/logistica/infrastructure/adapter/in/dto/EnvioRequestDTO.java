package com.logistica.infrastructure.adapter.in.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EnvioRequestDTO {

    private String tipoLogistica;
    private String tipoProducto;
    private int cantidad;
    private LocalDate fechaRegistro;
    private LocalDate fechaEntrega;
    private BigDecimal precioNormal;
    private BigDecimal precioConDescuento;
    private String numeroGuia;
    private String placaVehiculo;
    private String numeroFlota;
    private Long clienteId;
    private String estado;
    private String bodegaEntrega;
    private String puertoEntrega;
}
