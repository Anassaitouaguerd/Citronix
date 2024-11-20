package com.example.Citronix.services.recolte;

import com.example.Citronix.DTO.recolte.RecolteDTO;
import com.example.Citronix.DTO.recolte.RecolteReqDTO;
import com.example.Citronix.entity.Recolte;
import com.example.Citronix.mapper.RecolteMapper;
import com.example.Citronix.repository.recolte.RecolteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecolteService {
    private final RecolteRepository recolteRepository;
    private final RecolteMapper recolteMapper;

    @Transactional
    public RecolteDTO createRecolte(RecolteDTO recolteDTO) {
        return recolteMapper.toDTO(
                recolteRepository.save(recolteMapper.toEntity(recolteDTO)
                ));
    }

    @Transactional
    public RecolteDTO updateRecolte(Long id , RecolteReqDTO reqDTO) {
        Recolte existingRecolte = recolteRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Recolte not found"));

        Recolte recolte = recolteMapper.toEntity(reqDTO);
        recolte.setId(existingRecolte.getId());
        return recolteMapper.toDTO(recolte);
    }

    @Transactional(readOnly = true)
    public List<RecolteDTO> getAllRecoltes() {
        return recolteRepository.findAll().stream()
                              .map(recolteMapper::toDTO)
                              .collect(Collectors.toList());
    }

    @Transactional
    public void deleteRecolte(Long id) {
        recolteRepository.deleteById(id);
    }

}
