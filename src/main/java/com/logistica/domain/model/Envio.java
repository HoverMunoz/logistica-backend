package com.logistica.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Envio {

    private Long id;
    private String tipoLogistica;
    private String tipoProducto;
    private Integer cantidad;
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

    public Envio(Long id,
                 String tipoLogistica,
                 String tipoProducto,
                 Integer cantidad,
                 LocalDate fechaRegistro,
                 LocalDate fechaEntrega,
                 BigDecimal precioNormal,
                 BigDecimal precioConDescuento,
                 String numeroGuia,
                 String placaVehiculo,
                 String numeroFlota,
                 Long clienteId,
                 String estado,
                 String bodegaEntrega,
                 String puertoEntrega) {

        this.id = id;
        this.tipoLogistica = tipoLogistica;
        this.tipoProducto = tipoProducto;
        this.cantidad = cantidad;
        this.fechaRegistro = fechaRegistro;
        this.fechaEntrega = fechaEntrega;
        this.precioNormal = precioNormal;
        this.precioConDescuento = precioConDescuento;
        this.numeroGuia = numeroGuia;
        this.placaVehiculo = placaVehiculo;
        this.numeroFlota = numeroFlota;
        this.clienteId = clienteId;
        this.estado = estado;
        this.bodegaEntrega = bodegaEntrega;
        this.puertoEntrega = puertoEntrega;
    }
}