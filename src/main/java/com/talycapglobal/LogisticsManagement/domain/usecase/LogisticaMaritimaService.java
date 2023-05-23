package com.talycapglobal.LogisticsManagement.domain.usecase;

import com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto.MaritimaDTO;
import com.talycapglobal.LogisticsManagement.domain.model.Cliente;
import com.talycapglobal.LogisticsManagement.domain.model.LogisticaMaritima;
import com.talycapglobal.LogisticsManagement.domain.model.PuertoMaritimo;
import com.talycapglobal.LogisticsManagement.domain.model.TipoProducto;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.ClienteRepository;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.LogisticaMaritimaRepository;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.PuertoMaritimoRepository;
import com.talycapglobal.LogisticsManagement.domain.model.gateway.TipoProductoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class LogisticaMaritimaService {

    private final LogisticaMaritimaRepository logisticaMaritimaRepository;
    private final TipoProductoRepository tipoProductoRepository;
    private final PuertoMaritimoRepository puertoMaritimoRepository;
    private final ClienteRepository clienteRepository;

    public LogisticaMaritimaService(LogisticaMaritimaRepository logisticaMaritimaRepository,
                                    TipoProductoRepository tipoProductoRepository,
                                    PuertoMaritimoRepository puertoMaritimoRepository,
                                    ClienteRepository clienteRepository) {
        this.logisticaMaritimaRepository = logisticaMaritimaRepository;
        this.tipoProductoRepository = tipoProductoRepository;
        this.puertoMaritimoRepository = puertoMaritimoRepository;
        this.clienteRepository = clienteRepository;
    }

    public MaritimaDTO findById(Long id) {
        LogisticaMaritima logisticaMaritima = logisticaMaritimaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("LogisticaMaritima with ID " + id + " does not exist"));
        return mapEntityToDto(logisticaMaritima);
    }

    public List<MaritimaDTO> getAll() {
        return logisticaMaritimaRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }


    public List<MaritimaDTO> search(TipoProducto tipoProductoId, Integer cantidadProducto,
                                    LocalDate fechaRegistro, LocalDate fechaEntrega,
                                    PuertoMaritimo puertoEntregaId, Double precioEnvio,
                                    String numeroFlota, String numeroGuia,
                                    Double descuento, Cliente clienteId) {
        return logisticaMaritimaRepository.search(tipoProductoId, cantidadProducto, fechaRegistro,
                        fechaEntrega, puertoEntregaId, precioEnvio,
                        numeroFlota, numeroGuia, descuento, clienteId)
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }


    public void save(MaritimaDTO maritimaDTO) {
        LogisticaMaritima logisticaMaritima = mapDtoToEntity(maritimaDTO);
        logisticaMaritimaRepository.save(logisticaMaritima);
    }

    public void update(Long id, MaritimaDTO maritimaDTO) {
        LogisticaMaritima logisticaMaritima = logisticaMaritimaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("LogisticaMaritima with ID " + id + " does not exist"));
                        mapDtoToEntity(maritimaDTO, logisticaMaritima);
        logisticaMaritimaRepository.save(logisticaMaritima);
    }
    public void deleteById(Long id) {
        logisticaMaritimaRepository.deleteById(id);
    }

    private LogisticaMaritima mapDtoToEntity(MaritimaDTO maritimaDTO) {
        LogisticaMaritima logisticaMaritima = new LogisticaMaritima();
        mapDtoToEntity(maritimaDTO, logisticaMaritima);
        return logisticaMaritima;
    }

    private void mapDtoToEntity(MaritimaDTO maritimaDTO, LogisticaMaritima logisticaMaritima) {
        logisticaMaritima.setTipoProductoId(
                tipoProductoRepository.findById(maritimaDTO.getTipoProductoId())
                        .orElseThrow(() -> new NoSuchElementException("TipoProducto with ID " + maritimaDTO.getTipoProductoId() + " does not exist"))
        );
        logisticaMaritima.setCantidadProducto(maritimaDTO.getCantidadProducto());
        logisticaMaritima.setFechaRegistro(maritimaDTO.getFechaRegistro());
        logisticaMaritima.setFechaEntrega(maritimaDTO.getFechaEntrega());
        logisticaMaritima.setPuertoEntregaId(
                puertoMaritimoRepository.findById(maritimaDTO.getPuertoEntregaId())
                        .orElseThrow(() -> new NoSuchElementException("PuertoMaritimo with ID " + maritimaDTO.getPuertoEntregaId() + " does not exist"))
        );
        logisticaMaritima.setPrecioEnvio(maritimaDTO.getPrecioEnvio());
        logisticaMaritima.setNumeroFlota(maritimaDTO.getNumeroFlota());
        logisticaMaritima.setNumeroGuia(maritimaDTO.getNumeroGuia());
        logisticaMaritima.setDescuento(maritimaDTO.getDescuento());
        logisticaMaritima.setClienteId(
                clienteRepository.findById(maritimaDTO.getClienteId())
                        .orElseThrow(() -> new NoSuchElementException("Cliente with ID " + maritimaDTO.getClienteId() + " does not exist"))
        );
    }

    private MaritimaDTO mapEntityToDto(LogisticaMaritima logisticaMaritima) {
        MaritimaDTO maritimaDTO = new MaritimaDTO();
        maritimaDTO.setId(logisticaMaritima.getId());
        maritimaDTO.setTipoProductoId(logisticaMaritima.getTipoProductoId().getId());
        maritimaDTO.setCantidadProducto(logisticaMaritima.getCantidadProducto());
        maritimaDTO.setFechaRegistro(logisticaMaritima.getFechaRegistro());
        maritimaDTO.setFechaEntrega(logisticaMaritima.getFechaEntrega());
        maritimaDTO.setPuertoEntregaId(logisticaMaritima.getPuertoEntregaId().getId());
        maritimaDTO.setPrecioEnvio(logisticaMaritima.getPrecioEnvio());
        maritimaDTO.setNumeroFlota(logisticaMaritima.getNumeroFlota());
        maritimaDTO.setNumeroGuia(logisticaMaritima.getNumeroGuia());
        maritimaDTO.setDescuento(logisticaMaritima.getDescuento());
        maritimaDTO.setClienteId(logisticaMaritima.getClienteId().getId());
        return maritimaDTO;
    }
}
