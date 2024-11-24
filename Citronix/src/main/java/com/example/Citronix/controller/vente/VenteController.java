package com.example.Citronix.controller.vente;

import com.example.Citronix.DTO.vente.VenteDTO;
import com.example.Citronix.DTO.vente.VenteReqDTO;
import com.example.Citronix.services.vente.VenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vente")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VenteController {
    private final VenteService venteService;

    @PostMapping("/create")
    public ResponseEntity<VenteDTO> createVente(@Valid @RequestBody VenteReqDTO reqDTO) {
        return ResponseEntity.ok(venteService.createVente(reqDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VenteDTO> updateVente(@PathVariable Long id, @Valid @RequestBody VenteReqDTO reqDTO) {
        return ResponseEntity.ok(venteService.updateVente(id, reqDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<VenteDTO>> getAllVentes() {
        return ResponseEntity.ok(venteService.getAllVentes());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVente(@PathVariable Long id) {
        venteService.deleteVente(id);
    }
}
