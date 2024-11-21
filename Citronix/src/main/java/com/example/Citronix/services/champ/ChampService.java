package com.example.Citronix.services.champ;

import com.example.Citronix.DTO.champ.ChampDTO;
import com.example.Citronix.DTO.champ.ChampReqDTO;
import com.example.Citronix.entity.Champ;
import com.example.Citronix.entity.Ferme;
import com.example.Citronix.mapper.ChampMapper;
import com.example.Citronix.repository.champ.ChampRepository;
import com.example.Citronix.repository.ferme.FermeRepository;
import com.example.Citronix.services.ferme.FermeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChampService {
    private final ChampRepository champRepository;
    private final FermeRepository fermeRepository;
    private final ChampMapper champMapper;

    @Transactional
    public ChampDTO createChamp(ChampReqDTO reqDTO) {

        Optional<Ferme> ferme = Optional.ofNullable(fermeRepository.findById(reqDTO.getFerme_id())
                .orElseThrow(() -> new RuntimeException("Ferme not found")));

        Champ champ = champMapper.toEntity(reqDTO);
        champ.setFerme(ferme.get());

        return champMapper.toDTO(champRepository.save(champ));
    }

    @Transactional
    public ChampDTO updateChamp(Long id , ChampReqDTO reqDTO) {
        Champ existingChamp = champRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Champ not found"));

        Optional<Ferme> ferme = Optional.ofNullable(fermeRepository.findById(reqDTO.getFerme_id())
                .orElseThrow(() -> new RuntimeException("Ferme not found")));

        Champ champ = champMapper.toEntity(reqDTO);
        champ.setId(existingChamp.getId());
        champ.setFerme(ferme.get());
        return champMapper.toDTO(champRepository.save(champ));
    }

    @Transactional
    public List<ChampDTO> getAllChamps() {
        return champRepository.findAll().stream()
                              .map(champMapper::toDTO)
                              .collect(Collectors.toList());
    }

    @Transactional
    public void deleteChamp(Long id) {
        champRepository.deleteById(id);
    }
}
