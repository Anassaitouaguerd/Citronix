package com.example.Citronix.controller.champ;

import com.example.Citronix.DTO.champ.ChampDTO;
import com.example.Citronix.DTO.champ.ChampReqDTO;
import com.example.Citronix.services.champ.ChampService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/v1/champ")
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(name = "Field Management", description = "APIs for managing fields in the farm")
public class ChampController {
    private final ChampService champService;


    @Operation(
            summary = "Create a new field",
            description = "Creates a new field with the provided details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Field created successfully",
                    content = @Content(schema = @Schema(implementation = ChampDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/create")
    public ResponseEntity<ChampDTO> create(@Valid @RequestBody ChampReqDTO reqDto){
        return new ResponseEntity<>(champService.createChamp(reqDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update an existing field",
            description = "Updates a field's information based on the provided ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Field updated successfully"),
            @ApiResponse(responseCode = "404", description = "Field not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<ChampDTO> update(
            @Parameter(description = "ID of the field to update", required = true)
            @PathVariable Long id ,
            @Valid @RequestBody ChampReqDTO reqDTO){
        return ResponseEntity.ok(champService.updateChamp(id, reqDTO));
    }

    @Operation(
            summary = "Delete a field",
            description = "Deletes a field based on the provided ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Field deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Field not found")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(
            @Parameter(description = "ID of the field to delete", required = true)
            @PathVariable Long id){
        champService.deleteChamp(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Get all fields",
            description = "Retrieves a list of all fields in the system"
    )
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of fields")
    @GetMapping("/all")
    public ResponseEntity<List<ChampDTO>> getAllChamp(){
        return ResponseEntity.ok(champService.getAllChamps());
    }
}
