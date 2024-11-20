package com.example.Citronix.services.champ;

import com.example.Citronix.DTO.champ.ChampDTO;
import com.example.Citronix.DTO.champ.ChampReqDTO;
import com.example.Citronix.entity.Champ;
import com.example.Citronix.mapper.ChampMapper;
import com.example.Citronix.repository.champ.ChampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChampService {
    private final ChampRepository champRepository;
    private final ChampMapper champMapper;

    @Transactional
    public ChampDTO createChamp(ChampReqDTO reqDTO) {
        return champMapper.toDTO(
                champRepository.save(champMapper.toEntity(reqDTO)
                ));
    }

    @Transactional
    public ChampDTO updateChamp(Long id , ChampReqDTO reqDTO) {
        Champ existingChamp = champRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Champ not found"));

        Champ champ = champMapper.toEntity(reqDTO);
        champ.setId(existingChamp.getId());
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
