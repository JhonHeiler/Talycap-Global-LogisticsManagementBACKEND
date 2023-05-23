package com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
public class MaritimaInput {
    @NotBlank
    private Long tipoProductoId;
    @NotBlank
    private int cantidadProducto;
    @NotBlank
    private LocalDate fechaRegistro;
    @NotBlank
    private LocalDate fechaEntrega;
    @NotBlank
    private Long puertoEntregaId;
    @NotBlank
    private double precioEnvio;
    @NotBlank
    private String numeroFlota;
    @NotBlank
    private String numeroGuia;
}
