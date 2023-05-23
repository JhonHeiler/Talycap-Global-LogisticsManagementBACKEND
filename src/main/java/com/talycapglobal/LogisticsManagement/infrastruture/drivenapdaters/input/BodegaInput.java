package com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.input;

import com.talycapglobal.LogisticsManagement.domain.model.BodegaTerrestre;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BodegaInput {
    @NotBlank
    private String nombre;
    @NotBlank
    private String direccion;
    public BodegaInput(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public static BodegaTerrestre toBodegaTerrestre(BodegaInput bodegaInput) {
        if (bodegaInput == null) {
            throw new IllegalArgumentException("Bodega no puede ser nulo");
        }
        BodegaInput validaInput = new BodegaInput(bodegaInput.nombre, bodegaInput.getDireccion());
        BodegaTerrestre bodegaTerrestre = new BodegaTerrestre();
        bodegaTerrestre.setNombre(validaInput.getNombre());
        bodegaTerrestre.setDireccion(validaInput.getDireccion());
        return bodegaTerrestre;
    }
}
