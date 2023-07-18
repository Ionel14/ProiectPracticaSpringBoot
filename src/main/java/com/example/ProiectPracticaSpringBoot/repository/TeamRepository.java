package com.example.ProiectPracticaSpringBoot.repository;

import com.example.ProiectPracticaSpringBoot.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query(value="SELECT team.* FROM footballer INNER JOIN team ON footballer.id_team = team.id WHERE  footballer.id = :footballer_id"
            , nativeQuery = true)
    Team findByFootballerId(int footballer_id);
}
