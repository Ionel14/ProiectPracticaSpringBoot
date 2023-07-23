package com.example.ProiectPracticaSpringBoot.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TeamFormDto {

        private int id;
        private String name;
        private String location;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate foundationDate;

        private String coach;
        private String leagueName;
}
