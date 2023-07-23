package com.example.ProiectPracticaSpringBoot.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private int salary;
    private String position;
    private int teamId;
    private boolean isCaptain;
}
