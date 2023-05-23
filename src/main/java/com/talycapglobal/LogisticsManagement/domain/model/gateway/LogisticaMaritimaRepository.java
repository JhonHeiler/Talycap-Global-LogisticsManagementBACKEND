package com.talycapglobal.LogisticsManagement.domain.model.gateway;

import com.talycapglobal.LogisticsManagement.domain.model.Cliente;
import com.talycapglobal.LogisticsManagement.domain.model.LogisticaMaritima;
import com.talycapglobal.LogisticsManagement.domain.model.PuertoMaritimo;
import com.talycapglobal.LogisticsManagement.domain.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LogisticaMaritimaRepository extends JpaRepository<LogisticaMaritima, Long> {
    @Query("SELECT lm FROM LogisticaMaritima lm WHERE " +
            "(:tipoProductoId IS NULL OR lm.tipoProductoId = :tipoProductoId) AND " +
            "(:cantidadProducto IS NULL OR lm.cantidadProducto = :cantidadProducto) AND " +
            "(:fechaRegistro IS NULL OR lm.fechaRegistro = :fechaRegistro) AND " +
            "(:fechaEntrega IS NULL OR lm.fechaEntrega = :fechaEntrega) AND " +
            "(:puertoEntregaId IS NULL OR lm.puertoEntregaId = :puertoEntregaId) AND " +
            "(:precioEnvio IS NULL OR lm.precioEnvio = :precioEnvio) AND " +
            "(:numeroFlota IS NULL OR lm.numeroFlota = :numeroFlota) AND " +
            "(:numeroGuia IS NULL OR lm.numeroGuia = :numeroGuia) AND " +
            "(:descuento IS NULL OR lm.descuento = :descuento) AND " +
            "(:clienteId IS NULL OR lm.clienteId = :clienteId)")
    List<LogisticaMaritima> search(
            @Param("tipoProductoId") TipoProducto tipoProductoId,
            @Param("cantidadProducto") Integer cantidadProducto,
            @Param("fechaRegistro") LocalDate fechaRegistro,
            @Param("fechaEntrega") LocalDate fechaEntrega,
            @Param("puertoEntregaId") PuertoMaritimo puertoEntregaId,
            @Param("precioEnvio") Double precioEnvio,
            @Param("numeroFlota") String numeroFlota,
            @Param("numeroGuia") String numeroGuia,
            @Param("descuento") Double descuento,
            @Param("clienteId") Cliente clienteId);
}

