package com.example.ProiectPracticaSpringBoot.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamViewFootballerDto {
    private String firstname;
    private String lastname;
    private int teamId;
    private String position;
}
