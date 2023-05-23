package com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TipoProductoInput {
    @NotBlank
    private String nombre;

}
