package com.example.Citronix.controller.champ;

import com.example.Citronix.DTO.champ.ChampDTO;
import com.example.Citronix.DTO.champ.ChampReqDTO;
import com.example.Citronix.services.champ.ChampService;
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
public class ChampController {
    private final ChampService champService;

    @PostMapping("/create")
    public ResponseEntity<ChampDTO> create(@Valid @RequestBody ChampReqDTO reqDto){
        return new ResponseEntity<>(champService.createChamp(reqDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ChampDTO> update(@PathVariable Long id , @Valid @RequestBody ChampReqDTO reqDTO){
        return ResponseEntity.ok(champService.updateChamp(id, reqDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        champService.deleteChamp(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChampDTO>> getAllChamp(){
        return ResponseEntity.ok(champService.getAllChamps());
    }
}
