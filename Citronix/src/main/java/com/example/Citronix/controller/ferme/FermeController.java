package com.example.Citronix.controller.ferme;

import com.example.Citronix.DTO.farme.FermeDTO;
import com.example.Citronix.DTO.farme.FermeReqDTO;
import com.example.Citronix.entity.Ferme;
import com.example.Citronix.mapper.FermeMapper;
import com.example.Citronix.services.ferme.FermeService;
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
public class FermeController {
    private final FermeService fermeService;

    @PostMapping("/create")
    public ResponseEntity<FermeDTO> create(@Valid @RequestBody FermeReqDTO reqDTO) {
        return new ResponseEntity<>(fermeService.createFerme(reqDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FermeDTO> update(@PathVariable Long id, @Valid @RequestBody FermeReqDTO reqDTO) {
        return ResponseEntity.ok(fermeService.updateFerme(id, reqDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<FermeDTO>> getAll() {
        return ResponseEntity.ok(fermeService.getAllFermes());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        fermeService.deleteFerme(id);
        return ResponseEntity.ok().build();
    }
}
