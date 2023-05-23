package com.talycapglobal.LogisticsManagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class LogisticaMaritima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tipo_producto_id")
    private TipoProducto tipoProductoId;
    @Column(nullable = false)
    private int cantidadProducto;
    @Column(nullable = false)
    private LocalDate fechaRegistro;
    @Column(nullable = false)
    private LocalDate fechaEntrega;
    @ManyToOne
    @JoinColumn(name = "puerto_entrega_id")
    private PuertoMaritimo puertoEntregaId;
    @Column(nullable = false)
    private double precioEnvio;
    @Column(nullable = false)
    private String numeroFlota;
    @Column(nullable = false)
    private String numeroGuia;
    @Column
    private double descuento;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteId;
}
