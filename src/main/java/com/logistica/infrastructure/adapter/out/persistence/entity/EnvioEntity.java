package com.logistica.infrastructure.adapter.out.persistence.entity;

import com.logistica.domain.model.Envio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "envios")
@Getter
@Setter
public class EnvioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // ✅ CONVERTIR A DOMINIO
    public Envio toDomain() {
        return new Envio(
                id,
                tipoLogistica,
                tipoProducto,
                cantidad,
                fechaRegistro,
                fechaEntrega,
                precioNormal,
                precioConDescuento,
                numeroGuia,
                placaVehiculo,
                numeroFlota,
                clienteId,
                estado,
                bodegaEntrega,
                puertoEntrega
        );
    }

    // ✅ CONVERTIR A ENTITY
    public static EnvioEntity fromDomain(Envio envio) {
        EnvioEntity entity = new EnvioEntity();
        entity.id = envio.getId();
        entity.tipoLogistica = envio.getTipoLogistica();
        entity.tipoProducto = envio.getTipoProducto();
        entity.cantidad = envio.getCantidad();
        entity.fechaRegistro = envio.getFechaRegistro();
        entity.fechaEntrega = envio.getFechaEntrega();
        entity.precioNormal = envio.getPrecioNormal();
        entity.precioConDescuento = envio.getPrecioConDescuento();
        entity.numeroGuia = envio.getNumeroGuia();
        entity.placaVehiculo = envio.getPlacaVehiculo();
        entity.numeroFlota = envio.getNumeroFlota();
        entity.clienteId = envio.getClienteId();
        entity.estado = envio.getEstado();
        entity.bodegaEntrega = envio.getBodegaEntrega();
        entity.puertoEntrega = envio.getPuertoEntrega();
        return entity;
    }

}