package com.example.ProiectPracticaSpringBoot.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FootballerFormDto {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private int salary;
    private String position;
    private int teamId;
    private Boolean isCaptain;
}
