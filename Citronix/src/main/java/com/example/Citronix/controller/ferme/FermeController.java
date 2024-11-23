package com.example.Citronix.controller.ferme;

import com.example.Citronix.DTO.farme.FermeDTO;
import com.example.Citronix.DTO.farme.FermeReqDTO;
import com.example.Citronix.entity.Ferme;
import com.example.Citronix.mapper.FermeMapper;
import com.example.Citronix.services.ferme.FermeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ferme")
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(name = "Ferme Management", description = "APIs for managing farms")
public class FermeController {
    private final FermeService fermeService;

    @Operation(
            summary = "Create a new farm",
            description = "Creates a new farm with the provided details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Farm created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/create")
    public ResponseEntity<FermeDTO> create(@Valid @RequestBody FermeReqDTO reqDTO) {
        return new ResponseEntity<>(fermeService.createFerme(reqDTO), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update an existing farm",
            description = "Updates a farm's information based on the provided ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Farm updated successfully"),
            @ApiResponse(responseCode = "404", description = "Farm not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<FermeDTO> update(@Parameter(description = "ID of the farm to update")
                                               @PathVariable Long id, @Valid @RequestBody FermeReqDTO reqDTO) {
        return ResponseEntity.ok(fermeService.updateFerme(id, reqDTO));
    }

    @Operation(
            summary = "Get all farms",
            description = "Retrieves a list of all farms in the system"
    )
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of farms")
    @GetMapping("/all")
    public ResponseEntity<List<FermeDTO>> getAll() {
        return ResponseEntity.ok(fermeService.getAllFermes());
    }

    @Operation(
            summary = "Delete a farm",
            description = "Deletes a farm based on the provided ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Farm deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Farm not found")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        fermeService.deleteFerme(id);
        return ResponseEntity.ok().build();
    }
}
