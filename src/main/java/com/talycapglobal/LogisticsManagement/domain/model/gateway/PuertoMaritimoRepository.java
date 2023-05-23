package com.talycapglobal.LogisticsManagement.domain.model.gateway;

import com.talycapglobal.LogisticsManagement.domain.model.PuertoMaritimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuertoMaritimoRepository extends JpaRepository<PuertoMaritimo, Long> {
}