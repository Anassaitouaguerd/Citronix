package com.example.Citronix.services.arbre;

import com.example.Citronix.DTO.arbre.ArbreDTO;
import com.example.Citronix.DTO.arbre.ArbreReqDTO;
import com.example.Citronix.entity.Arbre;
import com.example.Citronix.mapper.ArbreMapper;
import com.example.Citronix.repository.arbre.ArbreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArbreService {
    private final ArbreRepository arbreRepository;
    private final ArbreMapper arbreMapper;

    @Transactional
    public ArbreDTO createArbre(ArbreReqDTO arbreReqDTO) {
        Arbre arbre = arbreRepository.save(arbreMapper.toEntity(arbreReqDTO));
        return arbreMapper.toDTO(arbre);
    }

    @Transactional
    public ArbreDTO updateArbre(Long id , ArbreReqDTO arbreReqDTO) {
        Arbre existingArbre = arbreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Arbre not found"));
        Arbre arbre = arbreMapper.toEntity(arbreReqDTO);
        arbre.setId(existingArbre.getId());
        return arbreMapper.toDTO(arbreRepository.save(arbre));
    }

    @Transactional
    public List<ArbreDTO> getAllArbres() {
            return arbreRepository.findAll().stream()
                    .map(arbreMapper::toDTO)
                    .collect(Collectors.toList());
    }

    @Transactional
    public void deleteArbre(Long id) {
        arbreRepository.deleteById(id);
    }
}
