package com.talycapglobal.LogisticsManagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    public Cliente() {
    }
}
