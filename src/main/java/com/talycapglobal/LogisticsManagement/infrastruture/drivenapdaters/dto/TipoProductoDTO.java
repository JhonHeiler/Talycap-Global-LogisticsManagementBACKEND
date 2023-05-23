package com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto;

import com.talycapglobal.LogisticsManagement.domain.model.TipoProducto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoProductoDTO {
    private Long id;
    private String nombre;

    public static TipoProducto convertToEntity(TipoProductoDTO tipoProductoDTO) {
        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setId(tipoProductoDTO.getId());
        tipoProducto.setNombre(tipoProductoDTO.getNombre());
        return tipoProducto;
    }

    public static TipoProductoDTO convertToDTO(TipoProducto tipoProducto) {
        TipoProductoDTO tipoProductoDTO = new TipoProductoDTO();
        tipoProductoDTO.setId(tipoProducto.getId());
        tipoProductoDTO.setNombre(tipoProducto.getNombre());
        return tipoProductoDTO;
    }
}
