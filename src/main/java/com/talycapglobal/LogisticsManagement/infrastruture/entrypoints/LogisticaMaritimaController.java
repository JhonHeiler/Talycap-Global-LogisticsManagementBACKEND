package com.talycapglobal.LogisticsManagement.infrastruture.entrypoints;

import com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto.MaritimaDTO;
import com.talycapglobal.LogisticsManagement.domain.model.Cliente;
import com.talycapglobal.LogisticsManagement.domain.model.PuertoMaritimo;
import com.talycapglobal.LogisticsManagement.domain.model.TipoProducto;
import com.talycapglobal.LogisticsManagement.domain.usecase.LogisticaMaritimaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/logisticas-maritimas")
public class LogisticaMaritimaController {

    private final LogisticaMaritimaService logisticaMaritimaService;

    public LogisticaMaritimaController(LogisticaMaritimaService logisticaMaritimaService) {
        this.logisticaMaritimaService = logisticaMaritimaService;
    }

    @GetMapping
    public ResponseEntity<List<MaritimaDTO>> getAllLogisticasMaritimas() {
        List<MaritimaDTO> logisticasMaritimas = logisticaMaritimaService.getAll();
        return new ResponseEntity<>(logisticasMaritimas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaritimaDTO> getLogisticaMaritimaById(@PathVariable Long id) {
        MaritimaDTO logisticaMaritima = logisticaMaritimaService.findById(id);
        return new ResponseEntity<>(logisticaMaritima, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createLogisticaMaritima(@RequestBody MaritimaDTO maritimaDTO) {
        logisticaMaritimaService.save(maritimaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLogisticaMaritima(@PathVariable Long id, @RequestBody MaritimaDTO maritimaDTO) {
        logisticaMaritimaService.update(id, maritimaDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogisticaMaritima(@PathVariable Long id) {
        logisticaMaritimaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/logisticaMaritima/search")
    public ResponseEntity<List<MaritimaDTO>> search(
            @RequestParam(required = false) TipoProducto tipoProductoId,
            @RequestParam(required = false) Integer cantidadProducto,
            @RequestParam(required = false) LocalDate fechaRegistro,
            @RequestParam(required = false) LocalDate fechaEntrega,
            @RequestParam(required = false) PuertoMaritimo puertoEntregaId,
            @RequestParam(required = false) Double precioEnvio,
            @RequestParam(required = false) String numeroFlota,
            @RequestParam(required = false) String numeroGuia,
            @RequestParam(required = false) Double descuento,
            @RequestParam(required = false) Cliente clienteId) {

        List<MaritimaDTO> logisticasMaritimas = logisticaMaritimaService.search(
                tipoProductoId, cantidadProducto, fechaRegistro, fechaEntrega, puertoEntregaId,
                precioEnvio, numeroFlota, numeroGuia, descuento, clienteId);
        return new ResponseEntity<>(logisticasMaritimas, HttpStatus.OK);
    }

}
