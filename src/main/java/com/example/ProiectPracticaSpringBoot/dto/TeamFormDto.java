package com.example.ProiectPracticaSpringBoot.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

        @NotEmpty(message = "Name can not be empty")
        @Size(min = 2, max = 30, message = "The name must have between {min} and {max} characters.")
        private String name;

        @NotEmpty(message = "Location can not be empty")
        @Size(min = 2, max = 30, message = "The location must have between {min} and {max} characters.")
        private String location;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate foundationDate;

        @NotEmpty(message = "Team must have a coach")
        @Size(min = 2, max = 50, message = "Coach name must have between {min} and {max} characters.")
        private String coach;

        private String leagueName;
}
