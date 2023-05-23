package com.talycapglobal.LogisticsManagement.infrastruture.entrypoints;

import com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.dto.PuertoDTO;
import com.talycapglobal.LogisticsManagement.domain.model.PuertoMaritimo;
import com.talycapglobal.LogisticsManagement.domain.usecase.PuertoMaritimoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/puertos-maritimos")
public class PuertoMaritimoController {

    private final PuertoMaritimoService puertoMaritimoService;

    public PuertoMaritimoController(PuertoMaritimoService puertoMaritimoService) {
        this.puertoMaritimoService = puertoMaritimoService;
    }

    @GetMapping
    public ResponseEntity<List<PuertoMaritimo>> getAllPuertosMaritimos() {
        List<PuertoMaritimo> puertosMaritimos = puertoMaritimoService.getAll();
        return new ResponseEntity<>(puertosMaritimos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PuertoMaritimo> getPuertoMaritimoById(@PathVariable Long id) {
        PuertoMaritimo puertoMaritimo = puertoMaritimoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Puerto Marítimo no encontrado"));
        return new ResponseEntity<>(puertoMaritimo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createPuertoMaritimo(@RequestBody PuertoDTO puertoDTO) {
        puertoMaritimoService.save(puertoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePuertoMaritimo(@PathVariable Long id, @RequestBody PuertoDTO puertoDTO) {
        puertoMaritimoService.update(id, puertoDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePuertoMaritimo(@PathVariable Long id) {
        puertoMaritimoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
