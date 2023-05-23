package com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MaritimaDTO {
    private Long id;
    private Long tipoProductoId;
    private int cantidadProducto;
    private LocalDate fechaRegistro;
    private LocalDate fechaEntrega;
    private Long puertoEntregaId;
    private double precioEnvio;
    private String numeroFlota;
    private String numeroGuia;
    private double descuento;
    private Long clienteId;
}

