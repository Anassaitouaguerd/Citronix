package com.example.Citronix.services.vente;

import com.example.Citronix.DTO.vente.VenteDTO;
import com.example.Citronix.DTO.vente.VenteReqDTO;
import com.example.Citronix.entity.Vente;
import com.example.Citronix.mapper.VenteMapper;
import com.example.Citronix.repository.vente.VenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VenteService {
    private final VenteRepository venteRepository;
    private final VenteMapper venteMapper;

    @Transactional
    public VenteDTO createVente(VenteReqDTO reqDTO) {
        return venteMapper.toDTO(
                venteRepository.save(venteMapper.toEntity(reqDTO)
                ));
    }

    @Transactional
    public VenteDTO updateVente(Long id , VenteReqDTO reqDTO) {
        Vente existiongVente = venteRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Vente not found"));

        Vente vente = venteMapper.toEntity(reqDTO);
        vente.setId(existiongVente.getId());
        return venteMapper.toDTO(vente);
    }

    @Transactional
    public List<VenteDTO> getAllVentes() {
        return venteRepository.findAll().stream()
                              .map(venteMapper::toDTO)
                              .collect(Collectors.toList());
    }

    @Transactional
    public void deleteVente(Long id) {
        venteRepository.deleteById(id);
    }
}
