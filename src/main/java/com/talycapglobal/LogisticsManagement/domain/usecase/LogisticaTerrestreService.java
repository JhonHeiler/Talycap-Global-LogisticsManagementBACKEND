package com.talycapglobal.LogisticsManagement.domain.usecase;

import com.talycapglobal.LogisticsManagement.domain.model.BodegaTerrestre;
import com.talycapglobal.LogisticsManagement.domain.model.Cliente;
import com.talycapglobal.LogisticsManagement.domain.model.LogisticaTerrestre;
import com.talycapglobal.LogisticsManagement.domain.model.TipoProducto;
import com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto.TerrestreDTO;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.BodegaTerrestreRepository;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.ClienteRepository;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.LogisticaTerrestreRepository;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.TipoProductoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class LogisticaTerrestreService {
    private final LogisticaTerrestreRepository logisticaTerrestreRepository;
    private final TipoProductoRepository tipoProductoRepository;
    private final BodegaTerrestreRepository bodegaTerrestreRepository;
    private final ClienteRepository clienteRepository;


    public LogisticaTerrestreService(LogisticaTerrestreRepository logisticaTerrestreRepository,
                                     TipoProductoRepository tipoProductoRepository,
                                     BodegaTerrestreRepository bodegaTerrestreRepository,
                                     ClienteRepository clienteRepository) {
        this.logisticaTerrestreRepository = logisticaTerrestreRepository;
        this.tipoProductoRepository = tipoProductoRepository;
        this.bodegaTerrestreRepository = bodegaTerrestreRepository;
        this.clienteRepository = clienteRepository;
    }

    public TerrestreDTO findById(Long id) {
        LogisticaTerrestre logisticaTerrestre = logisticaTerrestreRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("LogisticaTerrestre with ID " + id + " does not exist"));
        return mapEntityToDto(logisticaTerrestre);
    }

    public List<TerrestreDTO> getAll() {
        return logisticaTerrestreRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }


    public List<TerrestreDTO> search(TipoProducto tipoProductoId, Integer cantidadProducto,
                                     LocalDate fechaRegistro, LocalDate fechaEntrega,
                                     BodegaTerrestre bodegaEntregaId, Double precioEnvio,
                                     String placaVehiculo, String numeroGuia, Double descuento,
                                     Cliente clienteId) {
        return logisticaTerrestreRepository.search(tipoProductoId, cantidadProducto, fechaRegistro,
                        fechaEntrega, bodegaEntregaId, precioEnvio,
                        placaVehiculo, numeroGuia, descuento, clienteId)
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }



    public void update(Long id, TerrestreDTO terrestreDTO) {
        LogisticaTerrestre logisticaTerrestre = logisticaTerrestreRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("LogisticaTerrestre with ID " + id + " does not exist"));
        mapDtoToEntity(terrestreDTO, logisticaTerrestre);
        logisticaTerrestreRepository.save(logisticaTerrestre);
    }

    public void save(TerrestreDTO terrestreDTO) {
        LogisticaTerrestre logisticaTerrestre = new LogisticaTerrestre();
        mapDtoToEntity(terrestreDTO, logisticaTerrestre);
        logisticaTerrestreRepository.save(logisticaTerrestre);
    }

    public void deleteById(Long id) {
        logisticaTerrestreRepository.deleteById(id);
    }private void mapDtoToEntity(TerrestreDTO terrestreDTO, LogisticaTerrestre logisticaTerrestre) {
        logisticaTerrestre.setTipoProductoId(tipoProductoRepository.findById(terrestreDTO.getTipoProductoId())
                .orElseThrow(() -> new NoSuchElementException("TipoProducto with ID " + terrestreDTO.getTipoProductoId() + " does not exist")));
        logisticaTerrestre.setCantidadProducto(terrestreDTO.getCantidadProducto());
        logisticaTerrestre.setFechaRegistro(terrestreDTO.getFechaRegistro());
        logisticaTerrestre.setFechaEntrega(terrestreDTO.getFechaEntrega());
        logisticaTerrestre.setBodegaEntregaId(bodegaTerrestreRepository.findById(terrestreDTO.getBodegaEntregaId())
                .orElseThrow(() -> new NoSuchElementException("BodegaTerrestre with ID " + terrestreDTO.getBodegaEntregaId() + " does not exist")));
        logisticaTerrestre.setPrecioEnvio(terrestreDTO.getPrecioEnvio());
        logisticaTerrestre.setPlacaVehiculo(terrestreDTO.getPlacaVehiculo());
        logisticaTerrestre.setNumeroGuia(terrestreDTO.getNumeroGuia());
        logisticaTerrestre.setDescuento(terrestreDTO.getDescuento());
        logisticaTerrestre.setClienteId(clienteRepository.findById(terrestreDTO.getClienteId())
                .orElseThrow(() -> new NoSuchElementException("Cliente with ID " + terrestreDTO.getClienteId() + " does not exist")));
    }

    private TerrestreDTO mapEntityToDto(LogisticaTerrestre logisticaTerrestre) {
        TerrestreDTO terrestreDTO = new TerrestreDTO();
        terrestreDTO.setId(logisticaTerrestre.getId());
        terrestreDTO.setTipoProductoId(logisticaTerrestre.getTipoProductoId().getId());
        terrestreDTO.setCantidadProducto(logisticaTerrestre.getCantidadProducto());
        terrestreDTO.setFechaRegistro(logisticaTerrestre.getFechaRegistro());
        terrestreDTO.setFechaEntrega(logisticaTerrestre.getFechaEntrega());
        terrestreDTO.setBodegaEntregaId(logisticaTerrestre.getBodegaEntregaId().getId());
        terrestreDTO.setPrecioEnvio(logisticaTerrestre.getPrecioEnvio());
        terrestreDTO.setPlacaVehiculo(logisticaTerrestre.getPlacaVehiculo());
        terrestreDTO.setNumeroGuia(logisticaTerrestre.getNumeroGuia());
        terrestreDTO.setDescuento(logisticaTerrestre.getDescuento());
        terrestreDTO.setClienteId(logisticaTerrestre.getClienteId().getId());
        return terrestreDTO;
    }
}

