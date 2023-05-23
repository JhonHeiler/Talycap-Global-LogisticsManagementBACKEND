package com.talycapglobal.LogisticsManagement.domain.model.gateway;


import com.talycapglobal.LogisticsManagement.domain.model.BodegaTerrestre;
import com.talycapglobal.LogisticsManagement.domain.model.Cliente;
import com.talycapglobal.LogisticsManagement.domain.model.LogisticaTerrestre;
import com.talycapglobal.LogisticsManagement.domain.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LogisticaTerrestreRepository extends JpaRepository<LogisticaTerrestre, Long> {
    @Query("SELECT lm FROM LogisticaTerrestre lm WHERE " +
            "(:tipoProductoId IS NULL OR lm.tipoProductoId = :tipoProductoId) AND " +
            "(:cantidadProducto IS NULL OR lm.cantidadProducto = :cantidadProducto) AND " +
            "(:fechaRegistro IS NULL OR lm.fechaRegistro = :fechaRegistro) AND " +
            "(:fechaEntrega IS NULL OR lm.fechaEntrega = :fechaEntrega) AND " +
            "(:bodegaEntregaId IS NULL OR lm.bodegaEntregaId = :bodegaEntregaId) AND " +
            "(:precioEnvio IS NULL OR lm.precioEnvio = :precioEnvio) AND " +
            "(:placaVehiculo IS NULL OR lm.placaVehiculo = :placaVehiculo) AND " +
            "(:numeroGuia IS NULL OR lm.numeroGuia = :numeroGuia) AND " +
            "(:descuento IS NULL OR lm.descuento = :descuento) AND " +
            "(:clienteId IS NULL OR lm.clienteId = :clienteId)")
    List<LogisticaTerrestre> search(
            @Param("tipoProductoId") TipoProducto tipoProductoId,
            @Param("cantidadProducto") Integer cantidadProducto,
            @Param("fechaRegistro") LocalDate fechaRegistro,
            @Param("fechaEntrega") LocalDate fechaEntrega,
            @Param("bodegaEntregaId") BodegaTerrestre bodegaEntregaId,
            @Param("precioEnvio") Double precioEnvio,
            @Param("placaVehiculo") String placaVehiculo,
            @Param("numeroGuia") String numeroGuia,
            @Param("descuento") Double descuento,
            @Param("clienteId") Cliente clienteId);
}