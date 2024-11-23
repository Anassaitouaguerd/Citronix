package com.example.Citronix.controller.arbre;

import com.example.Citronix.DTO.arbre.ArbreDTO;
import com.example.Citronix.DTO.arbre.ArbreReqDTO;
import com.example.Citronix.services.arbre.ArbreService;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/arbre")
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(name = "Tree Management", description = "APIs for managing trees in the farm")
public class ArbreController {
    private final ArbreService arbreService;


    @Operation(
            summary = "Create a new tree",
            description = "Creates a new tree record with the provided details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tree created successfully",
                    content = @Content(schema = @Schema(implementation = ArbreDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/create")
    public ResponseEntity<ArbreDTO> createArbre(@Valid @RequestBody ArbreReqDTO Req) {
        return new ResponseEntity<>(arbreService.createArbre(Req), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update an existing tree",
            description = "Updates a tree's information based on the provided ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tree updated successfully"),
            @ApiResponse(responseCode = "404", description = "Tree not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<ArbreDTO> updateArbre(@Parameter(description = "ID of the tree to update")
                                                @PathVariable Long id ,
                                                @Valid @RequestBody ArbreReqDTO Req) {
        return ResponseEntity.ok(arbreService.updateArbre(id , Req));
    }

    @Operation(
            summary = "Delete a tree",
            description = "Deletes a tree based on the provided ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tree deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Tree not found")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArbre(
            @Parameter(description = "ID of the tree to delete", required = true)
            @PathVariable Long id){
        arbreService.deleteArbre(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Get all trees",
            description = "Retrieves a list of all trees in the system"
    )
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of trees")
    @GetMapping("/all")
    public ResponseEntity<List<ArbreDTO>> getAllArbres() {
        return ResponseEntity.ok(arbreService.getAllArbres());
    }

    @Operation(
            summary = "Get tree by ID",
            description = "Retrieves a specific tree by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the tree"),
            @ApiResponse(responseCode = "404", description = "Tree not found")
    })
    @GetMapping("/get/{id}")
    public ResponseEntity<ArbreDTO> getArbre(
            @Parameter(description = "ID of the tree to retrieve", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(arbreService.getArbreById(id));
    }
}
