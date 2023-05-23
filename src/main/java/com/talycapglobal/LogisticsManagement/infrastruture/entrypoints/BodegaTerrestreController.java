package com.talycapglobal.LogisticsManagement.infrastruture.entrypoints;
import com.talycapglobal.LogisticsManagement.domain.model.BodegaTerrestre;
import com.talycapglobal.LogisticsManagement.domain.usecase.BodegaTerrestreService;
import com.talycapglobal.LogisticsManagement.infrastruture.drivenapdaters.input.BodegaInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bodegas-terrestres")
public class BodegaTerrestreController {

    private final BodegaTerrestreService bodegaTerrestreService;

    public BodegaTerrestreController(BodegaTerrestreService bodegaTerrestreService) {
        this.bodegaTerrestreService = bodegaTerrestreService;
    }

    @GetMapping
    public ResponseEntity<List<BodegaTerrestre>> getAllBodegasTerrestres() {
        List<BodegaTerrestre> bodegasTerrestres = bodegaTerrestreService.getAll();
        return new ResponseEntity<>(bodegasTerrestres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodegaTerrestre> getBodegaTerrestreById(@PathVariable Long id) {
        Optional<BodegaTerrestre> bodegaTerrestre = bodegaTerrestreService.findById(id);
        if (bodegaTerrestre.isPresent()) {
            return new ResponseEntity<>(bodegaTerrestre.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createBodegaTerrestre(@RequestBody BodegaInput bodegaInput) {
        bodegaTerrestreService.save(BodegaInput.toBodegaTerrestre(bodegaInput));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBodegaTerrestre(@PathVariable Long id, @RequestBody BodegaInput bodegaInput) {
        try {
            bodegaTerrestreService.update(id,BodegaInput.toBodegaTerrestre(bodegaInput));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBodegaTerrestre(@PathVariable Long id) {
        bodegaTerrestreService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
