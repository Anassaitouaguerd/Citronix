package com.example.Citronix.services.arbre;

import com.example.Citronix.DTO.arbre.ArbreDTO;
import com.example.Citronix.DTO.arbre.ArbreReqDTO;
import com.example.Citronix.entity.Arbre;
import com.example.Citronix.entity.Champ;
import com.example.Citronix.entity.enums.TreeStatus;
import com.example.Citronix.exeptions.TreePlantingException;
import com.example.Citronix.mapper.ArbreMapper;
import com.example.Citronix.repository.arbre.ArbreRepository;
import com.example.Citronix.repository.champ.ChampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArbreService {
    private final ArbreRepository arbreRepository;
    private final ChampRepository champRepository;
    private final ArbreMapper arbreMapper;

    @Transactional
    public ArbreDTO createArbre(ArbreReqDTO arbreReqDTO) {

        int plantationMonth = arbreReqDTO.getPlantationDate().getMonthValue();
        if(plantationMonth < 3 || plantationMonth > 5){
            throw new TreePlantingException();
        }

        Champ champ = champRepository.findById(arbreReqDTO.getChamp_id())
                .orElseThrow(() -> new RuntimeException("Champ not found"));

        Arbre arbre = arbreMapper.toEntity(arbreReqDTO);
        arbre.setChamp(champ);
        int age = getArbreAge(arbreReqDTO.getPlantationDate());
        arbre.setStatus(getArbreStatus(age));

        return arbreMapper.toDTO(arbreRepository.save(arbre));
    }

    @Transactional
    public ArbreDTO updateArbre(Long id , ArbreReqDTO arbreReqDTO) {

        int plantationMonth = arbreReqDTO.getPlantationDate().getMonthValue();
        if(plantationMonth < 3 || plantationMonth > 5){
            throw new TreePlantingException();
        }

        Arbre existingArbre = arbreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Arbre not found"));

        Champ champ = champRepository.findById(arbreReqDTO.getChamp_id())
                .orElseThrow(() -> new RuntimeException("Champ not found"));

        Arbre arbre = arbreMapper.toEntity(arbreReqDTO);
        arbre.setId(existingArbre.getId());
        arbre.setChamp(champ);
        arbre.setStatus(
                getArbreStatus(
                        getArbreAge(
                                arbreReqDTO.getPlantationDate()
                        )
                )
        );
        return arbreMapper.toDTO(arbreRepository.save(arbre));
    }

    @Transactional
    public List<ArbreDTO> getAllArbres() {
            return arbreRepository.findAll().stream()
                    .map(this::enrichTreeWithCalculatedFields)
                    .collect(Collectors.toList());
    }

    private ArbreDTO enrichTreeWithCalculatedFields(Arbre arbre) {
        ArbreDTO arbreDTO = arbreMapper.toDTO(arbre);
        int age = getArbreAge(arbre.getPlantationDate());
        arbreDTO.setAge(age);
        arbreDTO.setProductivity(getArbreProductivityByAge(age));
        return arbreDTO;
    }

    @Transactional
    public void deleteArbre(Long id) {
        arbreRepository.deleteById(id);
    }

    @Transactional
    public ArbreDTO getArbreById(Long id) {
        Arbre arbre = arbreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Arbre not found"));

        ArbreDTO arbreDTO = arbreMapper.toDTO(arbre);
        arbreDTO.setAge(getArbreAge(arbre.getPlantationDate()));
        arbreDTO.setProductivity(getArbreProductivityByAge(arbreDTO.getAge()));
        return arbreDTO;
    }

    private int getArbreAge(LocalDate plantationDate) {
        return Period.between(plantationDate, LocalDate.now()).getYears();
    }

    private Double getArbreProductivityByAge(int age) {
        if (age < 3) return 2.5;
        if (age <= 10) return 12.0;
        if (age <= 20) return 20.0;
        return 0.0;
    }

    public Double getProductivityByArbreId(Long id) {
        Arbre arbre = arbreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Arbre not found"));
        int age = getArbreAge(arbre.getPlantationDate());
        return getArbreProductivityByAge(age);
    }

    private TreeStatus getArbreStatus(int age) {
        if (age < 3) return TreeStatus.YOUNG;
        if (age <= 10) return TreeStatus.PRODUCTIVE;
        if (age <= 20) return TreeStatus.NON_PRODUCTIVE;
        return TreeStatus.DEAD;
    }
}
