package com.talycapglobal.LogisticsManagement.domain.model.gateway;

import com.talycapglobal.LogisticsManagement.domain.model.BodegaTerrestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodegaTerrestreRepository extends JpaRepository<BodegaTerrestre, Long> {
    
}