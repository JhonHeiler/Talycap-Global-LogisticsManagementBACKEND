package com.talycapglobal.LogisticsManagement.domain.usecase;

import com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto.TipoProductoDTO;
import com.talycapglobal.LogisticsManagement.domain.model.TipoProducto;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.TipoProductoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoService {
    private final TipoProductoRepository tipoProductoRepository;

    public TipoProductoService(TipoProductoRepository tipoProductoRepository) {
        this.tipoProductoRepository = tipoProductoRepository;
    }

    public List<TipoProducto> getAll() {
        return tipoProductoRepository.findAll();
    }

    public TipoProducto findById(Long id) {
        return tipoProductoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
    }

    public void save(TipoProductoDTO tipoProductoDTO) {
        if (tipoProductoDTO == null) {
            throw new IllegalArgumentException("tipoProductoDTO no puede ser nulo");
        }

        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setNombre(tipoProductoDTO.getNombre());
        tipoProductoRepository.save(tipoProducto);
    }

    public void update(Long id, TipoProductoDTO tipoProductoDTO) {
        if (tipoProductoDTO == null) {
            throw new IllegalArgumentException("tipoProductoDTO no puede ser nulo");
        }

        TipoProducto tipoProducto = tipoProductoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        tipoProducto.setNombre(tipoProductoDTO.getNombre());
        tipoProductoRepository.save(tipoProducto);
    }
    public void deleteById(Long id) {
        tipoProductoRepository.deleteById(id);
    }
}
