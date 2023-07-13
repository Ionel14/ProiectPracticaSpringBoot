package com.example.ProiectPracticaSpringBoot.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Footballer {

    private int id;
    private int teamId;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private int salary;
    private String position;

}
