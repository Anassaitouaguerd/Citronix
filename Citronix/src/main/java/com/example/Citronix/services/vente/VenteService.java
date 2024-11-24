package com.example.Citronix.services.vente;

import com.example.Citronix.DTO.vente.VenteDTO;
import com.example.Citronix.DTO.vente.VenteReqDTO;
import com.example.Citronix.entity.Recolte;
import com.example.Citronix.entity.Vente;
import com.example.Citronix.exeptions.VenteDateAfterRecolteDateException;
import com.example.Citronix.mapper.VenteMapper;
import com.example.Citronix.repository.recolte.RecolteRepository;
import com.example.Citronix.repository.vente.VenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VenteService {
    private final VenteRepository venteRepository;
    private final RecolteRepository recolteRepository;
    private final VenteMapper venteMapper;

    @Transactional
    public VenteDTO createVente(VenteReqDTO reqDTO) {
        Recolte recolte = recolteRepository.findById(reqDTO.getRecolteId())
                          .orElseThrow(() -> new RuntimeException("Recolte not found"));

        Double revenue = reqDTO.getUntilPrice() * recolte.getTotalQuantity();

        validateDateOfVent(reqDTO.getDate() , recolte.getRecolteDate());

        Vente vente = venteMapper.toEntity(reqDTO);
        vente.setRecolte(recolte);
        vente.setRevenue(revenue);
        return venteMapper.toDTO(venteRepository.save(vente));
    }

    @Transactional
    public VenteDTO updateVente(Long id , VenteReqDTO reqDTO) {
        Vente existiongVente = venteRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Vente not found"));

        Recolte recolte = recolteRepository.findById(reqDTO.getRecolteId())
                .orElseThrow(() -> new RuntimeException("Recolte not found"));

        Double revenue = reqDTO.getUntilPrice() * recolte.getTotalQuantity();

        validateDateOfVent(reqDTO.getDate() , recolte.getRecolteDate());

        Vente vente = venteMapper.toEntity(reqDTO);
        vente.setId(existiongVente.getId());
        vente.setRecolte(recolte);
        vente.setRevenue(revenue);
        return venteMapper.toDTO(venteRepository.save(vente));
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

    private void validateDateOfVent(LocalDate venteDate , LocalDate recolteDate) {
        if (venteDate.isBefore(recolteDate)) {
            throw new VenteDateAfterRecolteDateException();
        }
    }
}
