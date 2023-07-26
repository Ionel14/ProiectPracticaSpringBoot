package com.example.ProiectPracticaSpringBoot.dto;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TeamOverviewDto {

    private int id;
    private String name;
    private int  playerCount;
    private String location;
    private LocalDate foundationDate;
    private String coach;
    private String captainName;
    private String leagueName;

}
