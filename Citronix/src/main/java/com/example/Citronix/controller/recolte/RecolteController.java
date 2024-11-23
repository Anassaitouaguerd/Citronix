package com.example.Citronix.controller.recolte;

import com.example.Citronix.DTO.recolte.RecolteDTO;
import com.example.Citronix.DTO.recolte.RecolteReqDTO;
import com.example.Citronix.entity.enums.SeasonType;
import com.example.Citronix.services.recolte.RecolteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recolte")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RecolteController {
    private final RecolteService recolteService;
    @PostMapping("/create")
    public ResponseEntity<RecolteDTO> createRecolte(@Valid @RequestBody RecolteReqDTO request) {
        return ResponseEntity.ok(recolteService.createRecolte(request));
    }

    @GetMapping("/field/{fieldId}")
    public ResponseEntity<List<RecolteDTO>> getHarvestsByField(@PathVariable Long fieldId) {
        return ResponseEntity.ok(recolteService.getRecolteByChamp(fieldId));
    }

    @GetMapping("/season/{season}")
    public ResponseEntity<List<RecolteDTO>> getHarvestsBySeason(@PathVariable SeasonType season) {
        return ResponseEntity.ok(recolteService.getHarvestsBySeason(season));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RecolteDTO>> getAllRecoltes() {
        return ResponseEntity.ok(recolteService.getAllRecoltes());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecolte(@PathVariable Long id) {
        recolteService.deleteRecolte(id);
        return ResponseEntity.ok("Recolte deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RecolteDTO> updateRecolte(@PathVariable Long id, @Valid @RequestBody RecolteReqDTO request) {
        return ResponseEntity.ok(recolteService.updateRecolte(id, request));
    }

}
