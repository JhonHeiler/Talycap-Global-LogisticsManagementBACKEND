package com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String gmail;
    private String password;
    private Long rolId;

}
