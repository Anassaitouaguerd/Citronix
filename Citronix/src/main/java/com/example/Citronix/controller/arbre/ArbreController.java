package com.example.Citronix.controller.arbre;

import com.example.Citronix.DTO.arbre.ArbreDTO;
import com.example.Citronix.DTO.arbre.ArbreReqDTO;
import com.example.Citronix.services.arbre.ArbreService;
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
public class ArbreController {
    private final ArbreService arbreService;

    @PostMapping("/create")
    public ResponseEntity<ArbreDTO> createArbre(@Valid @RequestBody ArbreReqDTO Req) {
        return new ResponseEntity<>(arbreService.createArbre(Req), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ArbreDTO> updateArbre(@PathVariable Long id ,
                                                @Valid @RequestBody ArbreReqDTO Req) {
        return ResponseEntity.ok(arbreService.updateArbre(id , Req));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArbre(@PathVariable Long id){
        arbreService.deleteArbre(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArbreDTO>> getAllArbres() {
        return ResponseEntity.ok(arbreService.getAllArbres());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ArbreDTO> getArbre(@PathVariable Long id) {
        return ResponseEntity.ok(arbreService.getArbreById(id));
    }
}
