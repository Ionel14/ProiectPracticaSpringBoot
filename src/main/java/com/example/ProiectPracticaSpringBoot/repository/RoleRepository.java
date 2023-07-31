package com.example.ProiectPracticaSpringBoot.repository;

import com.example.ProiectPracticaSpringBoot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}