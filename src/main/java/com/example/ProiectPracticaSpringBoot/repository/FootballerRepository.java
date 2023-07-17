package com.example.ProiectPracticaSpringBoot.repository;

import com.example.ProiectPracticaSpringBoot.model.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballerRepository extends JpaRepository<Footballer, Integer> {
}
