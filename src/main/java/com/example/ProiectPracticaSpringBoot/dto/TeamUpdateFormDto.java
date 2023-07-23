package com.example.ProiectPracticaSpringBoot.dto;

import com.example.ProiectPracticaSpringBoot.model.Footballer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamUpdateFormDto {

    private int id;
    private String name;
    private String location;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate foundationDate;

    private String coach;
    private String leagueName;
    private Footballer captain;
}
