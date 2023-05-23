package com.talycapglobal.LogisticsManagement.infrastruture.entrypoints;

import com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto.TipoProductoDTO;
import com.talycapglobal.LogisticsManagement.domain.model.TipoProducto;
import com.talycapglobal.LogisticsManagement.domain.usecase.TipoProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-producto")
public class TipoProductoController {

    private final TipoProductoService tipoProductoService;

    public TipoProductoController(TipoProductoService tipoProductoService) {
        this.tipoProductoService = tipoProductoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoProducto>> getAllTiposProducto() {
        List<TipoProducto> tiposProducto = tipoProductoService.getAll();
        return new ResponseEntity<>(tiposProducto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProducto> getTipoProductoById(@PathVariable Long id) {
        TipoProducto tipoProducto = tipoProductoService.findById(id);
        return new ResponseEntity<>(tipoProducto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createTipoProducto(@RequestBody TipoProductoDTO tipoProductoDTO) {
        tipoProductoService.save(tipoProductoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTipoProducto(@PathVariable Long id, @RequestBody TipoProductoDTO tipoProductoDTO) {
        tipoProductoService.update(id, tipoProductoDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoProducto(@PathVariable Long id) {
        tipoProductoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
