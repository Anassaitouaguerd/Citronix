package com.example.Citronix.services.ferme;

import com.example.Citronix.DTO.farme.FermeDTO;
import com.example.Citronix.DTO.farme.FermeReqDTO;
import com.example.Citronix.entity.Ferme;
import com.example.Citronix.mapper.FermeMapper;
import com.example.Citronix.repository.ferme.FermeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FermeService {
    private final FermeRepository fermeRepository;
    private final FermeMapper fermeMapper;

    @Transactional
    public FermeDTO createFerme(FermeReqDTO reqDTO) {
        return fermeMapper.toDTO(
                fermeRepository.save(fermeMapper.toEntity(reqDTO)
                ));
    }

    @Transactional
    public FermeDTO updateFerme(Long id , FermeReqDTO reqDTO) {
        Ferme existingFerme = fermeRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Ferme not found"));

        Ferme ferme = fermeMapper.toEntity(reqDTO);
        ferme.setId(existingFerme.getId());
        return fermeMapper.toDTO(fermeRepository.save(ferme));
    }

    @Transactional(readOnly = true)
    public List<FermeDTO> getAllFermes() {
        return fermeRepository.findAll().stream()
                              .map(fermeMapper::toDTO)
                              .collect(Collectors.toList());
    }

    @Transactional
    public void deleteFerme(Long id) {
        fermeRepository.deleteById(id);
    }
}
