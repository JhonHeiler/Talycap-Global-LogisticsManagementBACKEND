package com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
public class TerrestreDTO {
    private Long id;
    private Long tipoProductoId;
    private int cantidadProducto;
    private LocalDate fechaRegistro;
    private LocalDate fechaEntrega;
    private Long bodegaEntregaId;
    private double precioEnvio;
    private String placaVehiculo;
    private String numeroGuia;
    private double descuento;
    private Long clienteId;
}
