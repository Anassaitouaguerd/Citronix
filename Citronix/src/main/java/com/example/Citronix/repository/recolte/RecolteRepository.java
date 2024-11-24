package com.example.Citronix.repository.recolte;

import com.example.Citronix.entity.Recolte;
import com.example.Citronix.entity.enums.SeasonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RecolteRepository extends JpaRepository<Recolte, Long> {
    @Query("SELECT R FROM Recolte R WHERE R.champ.id = :champId AND R.recolteDate = :recolteDate")
    Recolte findByChampIdAndRecolteDate(@Param("champId") Long champId,@Param("recolteDate") LocalDate recolteDate);

    @Query("SELECT R FROM Recolte R JOIN RecolteDetails Rd ON R.id = Rd.recolte.id" +
            " WHERE Rd.arbre.id = :arbreId AND R.season = :seasonType")
    List<Recolte> existsByArbreAndSeason(@Param("arbreId") Long arbreId, @Param("seasonType") SeasonType seasonType);

    @Query("SELECT R FROM Recolte R WHERE R.champ.id = :champId")
    List<Recolte> findByChampId(@Param("champId") Long champId);

    @Query("SELECT R FROM Recolte R WHERE R.season = :seasonType")
    List<Recolte> findBySeason(@Param("seasonType") SeasonType seasonType);
}
