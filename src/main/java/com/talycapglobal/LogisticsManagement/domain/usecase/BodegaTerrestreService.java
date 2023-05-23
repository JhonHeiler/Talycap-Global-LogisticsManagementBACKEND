package com.talycapglobal.LogisticsManagement.domain.usecase;
import com.talycapglobal.LogisticsManagement.domain.model.BodegaTerrestre;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.BodegaTerrestreRepository;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodegaTerrestreService {
    private final BodegaTerrestreRepository bodegaTerrestreRepository;

    public BodegaTerrestreService(BodegaTerrestreRepository bodegaTerrestreRepository) {
        this.bodegaTerrestreRepository = bodegaTerrestreRepository;
    }

    public List<BodegaTerrestre> getAll() {
        return bodegaTerrestreRepository.findAll();
    }

    public Optional<BodegaTerrestre> findById(Long id) {
        return bodegaTerrestreRepository.findById(id);
    }

    public void save(BodegaTerrestre bodega) {
        bodegaTerrestreRepository.save(bodega);
    }

    public void update(Long id, BodegaTerrestre bodega) {
        Optional<BodegaTerrestre> bodegaTerrestreExistente = bodegaTerrestreRepository.findById(id);
        if (bodegaTerrestreExistente.isPresent()) {
            bodegaTerrestreRepository.save(bodega);
        } else {
            throw new IllegalArgumentException("Bodega Terrestre no encontrada");
        }
    }

    public void deleteById(Long id) {
        bodegaTerrestreRepository.deleteById(id);
    }
}

