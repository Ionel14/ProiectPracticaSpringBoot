package com.example.ProiectPracticaSpringBoot.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FootballerFormDto {

    private int id;

    @NotEmpty(message = "The firstname can not be empty")
    @Size(min = 2, max = 20, message = "The firstname must have between {min} and {max} characters.")
    private String firstname;

    @NotEmpty(message = "The lastname can not be empty")
    @Size(min = 2, max = 20, message = "The lastname must have between {min} and {max} characters.")
    private String lastname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Range(min = 2000, max = 5000, message = "The salary must be between {min} and {max}.")
    private int salary;

    private String position;
    private int teamId;
}
