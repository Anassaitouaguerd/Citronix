package com.example.Citronix.controller.vente;

import com.example.Citronix.DTO.vente.VenteDTO;
import com.example.Citronix.DTO.vente.VenteReqDTO;
import com.example.Citronix.services.vente.VenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vente")
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(name = "Sales Management", description = "APIs for managing sales")
public class VenteController {
    private final VenteService venteService;


    @Operation(
            summary = "Create a new sale",
            description = "Creates a new sale record with the provided details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sale created successfully",
                    content = @Content(schema = @Schema(implementation = VenteDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/create")
    public ResponseEntity<VenteDTO> createVente(@Valid @RequestBody VenteReqDTO reqDTO) {
        return ResponseEntity.ok(venteService.createVente(reqDTO));
    }

    @Operation(
            summary = "Update an existing sale",
            description = "Updates a sale record based on the provided ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sale updated successfully"),
            @ApiResponse(responseCode = "404", description = "Sale not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<VenteDTO> updateVente(
            @Parameter(description = "ID of the sale to update", required = true)
            @PathVariable Long id,
            @Valid @RequestBody VenteReqDTO reqDTO) {
        return ResponseEntity.ok(venteService.updateVente(id, reqDTO));
    }

    @Operation(
            summary = "Get all sales",
            description = "Retrieves a list of all sales in the system"
    )
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of sales")
    @GetMapping("/all")
    public ResponseEntity<List<VenteDTO>> getAllVentes() {
        return ResponseEntity.ok(venteService.getAllVentes());
    }

    @Operation(
            summary = "Delete a sale",
            description = "Deletes a sale record based on the provided ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sale deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Sale not found")
    })
    @DeleteMapping("/delete/{id}")
    public void deleteVente(
            @Parameter(description = "ID of the sale to delete", required = true)
            @PathVariable Long id) {
        venteService.deleteVente(id);
    }
}
