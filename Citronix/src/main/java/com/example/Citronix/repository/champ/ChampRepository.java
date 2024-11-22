package com.example.Citronix.repository.champ;

import com.example.Citronix.entity.Champ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChampRepository extends JpaRepository<Champ, Long> {
    @Query("SELECT COUNT(c) FROM Champ c WHERE c.ferme = :fermeId")
    Long countAllChampByFermeId(@Param("fermeId") Long fermeId);
}
