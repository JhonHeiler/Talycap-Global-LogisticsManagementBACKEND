package com.talycapglobal.LogisticsManagement.domain.usecase;

import com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto.PuertoDTO;
import com.talycapglobal.LogisticsManagement.domain.model.PuertoMaritimo;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.PuertoMaritimoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuertoMaritimoService {
    private final PuertoMaritimoRepository puertoMaritimoRepository;

    public PuertoMaritimoService(PuertoMaritimoRepository puertoMaritimoRepository) {
        this.puertoMaritimoRepository = puertoMaritimoRepository;
    }

    public List<PuertoMaritimo> getAll() {
        return puertoMaritimoRepository.findAll();
    }

    public Optional<PuertoMaritimo> findById(Long id) {
        return puertoMaritimoRepository.findById(id);
    }

    public void save(PuertoDTO puertoDTO) {
        if (puertoDTO == null) {
            throw new IllegalArgumentException("puertoMaritimoDTO no puede ser nulo");
        }

        PuertoMaritimo puertoMaritimo = PuertoDTO.convertToEntity(puertoDTO);
        puertoMaritimoRepository.save(puertoMaritimo);
    }

    public void update(Long id, PuertoDTO puertoDTO) {
        if (puertoDTO == null) {
            throw new IllegalArgumentException("puertoMaritimoDTO no puede ser nulo");
        }

        Optional<PuertoMaritimo> puertoMaritimoExistente = puertoMaritimoRepository.findById(id);
        if (puertoMaritimoExistente.isPresent()) {
            PuertoMaritimo puertoMaritimo = puertoMaritimoExistente.get();
            puertoMaritimo.setNombre(puertoDTO.getNombre());
            puertoMaritimo.setUbicacion(puertoDTO.getUbicacion());
            // Actualizar otros campos según corresponda
            puertoMaritimoRepository.save(puertoMaritimo);
        } else {
            throw new IllegalArgumentException("Puerto Marítimo no encontrado");
        }
    }

    public void deleteById(Long id) {
        puertoMaritimoRepository.deleteById(id);
    }
}
