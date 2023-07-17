package com.example.ProiectPracticaSpringBoot.repository;

import com.example.ProiectPracticaSpringBoot.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
