package com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto;

import com.talycapglobal.LogisticsManagement.domain.model.PuertoMaritimo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PuertoDTO {
    private Long id;
    private String nombre;
    private String ubicacion;

    public static PuertoDTO convertToDTO(PuertoMaritimo puertoMaritimo) {
        PuertoDTO puertoDTO = new PuertoDTO();
        puertoDTO.setId(puertoMaritimo.getId());
        puertoDTO.setNombre(puertoMaritimo.getNombre());
        puertoDTO.setUbicacion(puertoMaritimo.getUbicacion());
        return puertoDTO;
    }

    public static PuertoMaritimo convertToEntity(PuertoDTO puertoDTO) {
        PuertoMaritimo puertoMaritimo = new PuertoMaritimo();
        puertoMaritimo.setId(puertoDTO.getId());
        puertoMaritimo.setNombre(puertoDTO.getNombre());
        puertoMaritimo.setUbicacion(puertoDTO.getUbicacion());
        return puertoMaritimo;
    }
}
