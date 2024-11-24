package com.example.Citronix.services.recolte;

import com.example.Citronix.DTO.recolte.RecolteDTO;
import com.example.Citronix.DTO.recolte.RecolteDetailsReqDTO;
import com.example.Citronix.DTO.recolte.RecolteReqDTO;
import com.example.Citronix.entity.Arbre;
import com.example.Citronix.entity.Champ;
import com.example.Citronix.entity.Recolte;
import com.example.Citronix.entity.RecolteDetails;
import com.example.Citronix.entity.enums.SeasonType;
import com.example.Citronix.exeptions.ArbreNotBelongsToChampException;
import com.example.Citronix.exeptions.RecolteAlreadyExistsForThisSeason;
import com.example.Citronix.exeptions.ValidateRecolteQuantityException;
import com.example.Citronix.mapper.RecolteMapper;
import com.example.Citronix.repository.arbre.ArbreRepository;
import com.example.Citronix.repository.champ.ChampRepository;
import com.example.Citronix.repository.recolte.RecolteRepository;
import com.example.Citronix.services.arbre.ArbreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecolteService {
    private final RecolteRepository recolteRepository;
    private final ChampRepository champRepository;
    private final ArbreRepository arbreRepository;
    private final ArbreService arbreService;
    private final RecolteMapper recolteMapper;

    @Transactional
    public RecolteDTO createRecolte(RecolteReqDTO recolteReqDTO) {
        Champ champ = champRepository.findById(recolteReqDTO.getChampId())
                     .orElseThrow(() -> new RuntimeException("Champ not found"));

        validateNoHarvestForSeason(champ.getId(), recolteReqDTO.getRecolteDate());

        SeasonType seasonType = getSeasonType(recolteReqDTO.getRecolteDate());

        Recolte recolte = Recolte.builder()
                .champ(champ)
                .recolteDate(recolteReqDTO.getRecolteDate())
                .season(seasonType)
                .build();

        ArrayList<RecolteDetails> recolteDetails = new ArrayList<>();
        double totalQuantity = 0;
        for(RecolteDetailsReqDTO recolteDetailsReqDTO : recolteReqDTO.getRecolteDetails()) {
            Arbre arbre = arbreRepository.findById(recolteDetailsReqDTO.getArbreId())
                         .orElseThrow(() -> new RuntimeException("Arbre not found"));

            validateArbreBelongsToChamp(arbre, champ);

            existsByArbreAndSeason(arbre.getId(), seasonType, recolteReqDTO.getRecolteDate());

            validateRecolteQuantity(arbre.getId(), recolteDetailsReqDTO.getQuantity());

            RecolteDetails detail = RecolteDetails.builder()
                    .arbre(arbre)
                    .quantity(recolteDetailsReqDTO.getQuantity())
                    .recolte(recolte)
                    .build();

            recolteDetails.add(detail);
            totalQuantity += recolteDetailsReqDTO.getQuantity();
        }
        recolte.setRecolteDetails(recolteDetails);
        recolte.setTotalQuantity(totalQuantity);

        return recolteMapper.toDTO(recolteRepository.save(recolte));

    }

    @Transactional
    public RecolteDTO updateRecolte(Long id , RecolteReqDTO reqDTO) {
        Recolte existingRecolte = recolteRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Recolte not found"));

        Champ champ = champRepository.findById(reqDTO.getChampId())
                .orElseThrow(() -> new RuntimeException("Champ not found"));

        validateNoHarvestForSeason(champ.getId(), reqDTO.getRecolteDate());

        SeasonType seasonType = getSeasonType(reqDTO.getRecolteDate());

        Recolte recolte = Recolte.builder()
                .id(existingRecolte.getId())
                .champ(champ)
                .recolteDate(reqDTO.getRecolteDate())
                .season(seasonType)
                .build();

        ArrayList<RecolteDetails> recolteDetailsUp = new ArrayList<>();
        double totalQuantity = 0;
        for(RecolteDetailsReqDTO recolteDetailsReqDTO : reqDTO.getRecolteDetails()) {
            Arbre arbre = arbreRepository.findById(recolteDetailsReqDTO.getArbreId())
                    .orElseThrow(() -> new RuntimeException("Arbre not found"));

            validateArbreBelongsToChamp(arbre, champ);

            existsByArbreAndSeason(arbre.getId(), seasonType, reqDTO.getRecolteDate());

            validateRecolteQuantity(arbre.getId(), recolteDetailsReqDTO.getQuantity());

            RecolteDetails detail = RecolteDetails.builder()
                    .arbre(arbre)
                    .quantity(recolteDetailsReqDTO.getQuantity())
                    .recolte(recolte)
                    .build();

            recolteDetailsUp.add(detail);
            totalQuantity += recolteDetailsReqDTO.getQuantity();
        }
        recolte.setRecolteDetails(recolteDetailsUp);
        recolte.setTotalQuantity(totalQuantity);

        return recolteMapper.toDTO(recolteRepository.save(recolte));

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

    private void validateNoHarvestForSeason(Long champId , LocalDate recolteDate) {
        Recolte recolte = recolteRepository.findByChampIdAndRecolteDate(champId, recolteDate);
        if (recolte != null) {
            throw new RecolteAlreadyExistsForThisSeason();
        }
    }

    private SeasonType getSeasonType(LocalDate recolteDate) {
        int month = recolteDate.getMonthValue();
        if (month >= 3 && month <= 5) return SeasonType.SPRING;
        if (month >= 6 && month <= 8) return SeasonType.SUMMER;
        if (month >= 9 && month <= 11) return SeasonType.FALL;
        return SeasonType.WINTER;
    }

    private void validateArbreBelongsToChamp(Arbre arbre , Champ champ) {
        if (!arbre.getChamp().getId().equals(champ.getId())) {
            throw new ArbreNotBelongsToChampException();
        }
    }

    private void existsByArbreAndSeason(Long ArbreId, SeasonType seasonType , LocalDate recolteDate) {
        List<Recolte> isRecolted = recolteRepository.existsByArbreAndSeason(ArbreId, seasonType);
        if (!isRecolted.isEmpty()) {
            for(Recolte recolte : isRecolted) {
                if (recolte.getRecolteDate().getYear() == recolteDate.getYear()) {
                    throw new RecolteAlreadyExistsForThisSeason();
                }
            }
        }
    }

    private void validateRecolteQuantity(Long arbreId , Double quantity) {
        if (arbreService.getProductivityByArbreId(arbreId) < quantity) {
            throw new ValidateRecolteQuantityException();
        }
    }

    // Get methods
    public List<RecolteDTO> getRecolteByChamp(Long champId) {
        List<Recolte> harvests = recolteRepository.findByChampId(champId);
        return harvests.stream()
                .map(recolteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<RecolteDTO> getHarvestsBySeason(SeasonType season) {
        List<Recolte> recoltes = recolteRepository.findBySeason(season);
        return recoltes.stream()
                .map(recolteMapper::toDTO)
                .collect(Collectors.toList());
    }

}
