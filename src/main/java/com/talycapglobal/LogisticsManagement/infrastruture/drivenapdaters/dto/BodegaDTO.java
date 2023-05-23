package com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto;
import com.talycapglobal.LogisticsManagement.domain.model.BodegaTerrestre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodegaDTO {
    private Long id;
    private String nombre;
    private String direccion;

    public static BodegaTerrestre convertToEntity(BodegaDTO bodegaDTO) {
        BodegaTerrestre bodegaTerrestre = new BodegaTerrestre();
        bodegaTerrestre.setId(bodegaDTO.getId());
        bodegaTerrestre.setNombre(bodegaDTO.getNombre());
        bodegaTerrestre.setDireccion(bodegaDTO.getDireccion());
        return bodegaTerrestre;
    }

    public static BodegaDTO convertToDTO(BodegaTerrestre bodegaTerrestre) {
        BodegaDTO bodegaDTO = new BodegaDTO();
        bodegaDTO.setId(bodegaTerrestre.getId());
        bodegaDTO.setNombre(bodegaTerrestre.getNombre());
        bodegaDTO.setDireccion(bodegaTerrestre.getDireccion());
        return bodegaDTO;
    }



}
