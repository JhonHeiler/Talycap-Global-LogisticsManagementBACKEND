package com.talycapglobal.LogisticsManagement.infrastruture.entrypoints;

import com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto.TerrestreDTO;
import com.talycapglobal.LogisticsManagement.domain.model.BodegaTerrestre;
import com.talycapglobal.LogisticsManagement.domain.model.Cliente;
import com.talycapglobal.LogisticsManagement.domain.model.TipoProducto;
import com.talycapglobal.LogisticsManagement.domain.usecase.LogisticaTerrestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/logistica/terrestre")
public class LogisticaTerrestreController {
    private final LogisticaTerrestreService logisticaTerrestreService;

    @Autowired
    public LogisticaTerrestreController(LogisticaTerrestreService logisticaTerrestreService) {
        this.logisticaTerrestreService = logisticaTerrestreService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TerrestreDTO> findById(@PathVariable Long id) {
        TerrestreDTO terrestreDTO = logisticaTerrestreService.findById(id);
        return ResponseEntity.ok(terrestreDTO);
    }

    @GetMapping
    public ResponseEntity<List<TerrestreDTO>> getAll() {
        List<TerrestreDTO> terrestreDTOList = logisticaTerrestreService.getAll();
        return ResponseEntity.ok(terrestreDTOList);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody TerrestreDTO terrestreDTO) {
        logisticaTerrestreService.save(terrestreDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody TerrestreDTO terrestreDTO) {
        logisticaTerrestreService.update(id, terrestreDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        logisticaTerrestreService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/logisticaterrestre/search")
    public ResponseEntity<List<TerrestreDTO>> search(
            @RequestParam(required = false) TipoProducto tipoProductoId,
            @RequestParam(required = false) Integer cantidadProducto,
            @RequestParam(required = false) LocalDate fechaRegistro,
            @RequestParam(required = false) LocalDate fechaEntrega,
            @RequestParam(required = false) BodegaTerrestre bodegaEntregaId,
            @RequestParam(required = false) Double precioEnvio,
            @RequestParam(required = false) String placaVehiculo,
            @RequestParam(required = false) String numeroGuia,
            @RequestParam(required = false) Double descuento,
            @RequestParam(required = false) Cliente clienteId) {

        List<TerrestreDTO> logisticaTerrestres = logisticaTerrestreService.search(
                tipoProductoId, cantidadProducto, fechaRegistro, fechaEntrega,
                bodegaEntregaId, precioEnvio, placaVehiculo, numeroGuia, descuento, clienteId);
        return new ResponseEntity<>(logisticaTerrestres , HttpStatus.OK);
    }
}
