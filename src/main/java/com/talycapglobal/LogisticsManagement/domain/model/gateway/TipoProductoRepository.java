package com.talycapglobal.LogisticsManagement.domain.model.gateway;

import com.talycapglobal.LogisticsManagement.domain.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
}