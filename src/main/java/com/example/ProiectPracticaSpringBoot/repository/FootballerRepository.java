package com.example.ProiectPracticaSpringBoot.repository;

import com.example.ProiectPracticaSpringBoot.model.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballerRepository extends JpaRepository<Footballer, Integer> {

    @Query(value = "SELECT footballer.* FROM footballer INNER JOIN team ON footballer.id_team = team.id WHERE team.id = :team_id ", nativeQuery = true)
    List<Footballer> findByTeamId(int team_id);
}
