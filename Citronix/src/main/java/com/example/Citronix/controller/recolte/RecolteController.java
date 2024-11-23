package com.example.Citronix.controller.recolte;

import com.example.Citronix.DTO.recolte.RecolteDTO;
import com.example.Citronix.DTO.recolte.RecolteReqDTO;
import com.example.Citronix.entity.enums.SeasonType;
import com.example.Citronix.services.recolte.RecolteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recolte")
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(name = "Harvest Management", description = "APIs for managing harvests")
public class RecolteController {
    private final RecolteService recolteService;


    @Operation(
            summary = "Create a new harvest",
            description = "Records a new harvest with the provided details"
    )
    @PostMapping("/create")
    public ResponseEntity<RecolteDTO> createRecolte(@Valid @RequestBody RecolteReqDTO request) {
        return ResponseEntity.ok(recolteService.createRecolte(request));
    }

    @Operation(
            summary = "Get harvests by field",
            description = "Retrieves all harvests for a specific field"
    )
    @GetMapping("/field/{fieldId}")
    public ResponseEntity<List<RecolteDTO>> getHarvestsByField(@Parameter(description = "ID of the field")
                                                                   @PathVariable Long fieldId) {
        return ResponseEntity.ok(recolteService.getRecolteByChamp(fieldId));
    }

    @Operation(
            summary = "Get harvests by season",
            description = "Retrieves all harvests for a specific season"
    )
    @GetMapping("/season/{season}")
    public ResponseEntity<List<RecolteDTO>> getHarvestsBySeason(@Parameter(description = "type of season") @PathVariable SeasonType season) {
        return ResponseEntity.ok(recolteService.getHarvestsBySeason(season));
    }

    @Operation(
            summary = "Get All harvests",
            description = "Retrieves all harvests in the database"
    )
    @GetMapping("/all")
    public ResponseEntity<List<RecolteDTO>> getAllRecoltes() {
        return ResponseEntity.ok(recolteService.getAllRecoltes());
    }

    @Operation(
            summary = "Delete a harvest",
            description = "Deletes a harvest based on the provided ID"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecolte(@Parameter(description = "ID of the recolte") @PathVariable Long id) {
        recolteService.deleteRecolte(id);
        return ResponseEntity.ok("Recolte deleted successfully");
    }


    @Operation(
            summary = "Update a harvest",
            description = "Update a harvest based on the provided ID"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<RecolteDTO> updateRecolte(@Parameter(description = "ID of the recolte") @PathVariable Long id, @Valid @RequestBody RecolteReqDTO request) {
        return ResponseEntity.ok(recolteService.updateRecolte(id, request));
    }

}
