package com.example.ProiectPracticaSpringBoot.mapper;

import com.example.ProiectPracticaSpringBoot.dto.FootballerFormDto;
import com.example.ProiectPracticaSpringBoot.dto.FootballerOfTeamDto;
import com.example.ProiectPracticaSpringBoot.dto.FootballerOverviewDto;
import com.example.ProiectPracticaSpringBoot.dto.TeamViewFootballerDto;
import com.example.ProiectPracticaSpringBoot.model.Footballer;
import com.example.ProiectPracticaSpringBoot.model.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FootballerMapper {

    public List<FootballerOverviewDto> getFootballerDtoList(List<Footballer> footballers)
    {
        return footballers.stream()
                .map(footballer -> mapToFootballerOverviewDto(footballer))
                .collect(Collectors.toList());
    }

    public FootballerOverviewDto mapToFootballerOverviewDto(Footballer footballer)
    {
        return FootballerOverviewDto.builder()
                .id(footballer.getId())
                .firstname(footballer.getFirstname())
                .lastname(footballer.getLastname())
                .salary(footballer.getSalary())
                .position(footballer.getPosition())
                .birthday(footballer.getBirthday())
                .teamName((footballer.getTeam() != null) ? footballer.getTeam().getName() : "Free Agent")
                .build();
    }

    public Footballer mapToFootballer(FootballerFormDto footballer)
    {
        return Footballer.builder()
                .firstname(footballer.getFirstname())
                .lastname(footballer.getLastname())
                .salary(footballer.getSalary())
                .position(footballer.getPosition())
                .birthday(footballer.getBirthday())
                .team(Team.builder()
                        .id(footballer.getTeamId())
                        .build())
                .id(footballer.getId())
                .build();
    }

    public FootballerFormDto mapToFootballerFormDto(Footballer footballer)
    {
        FootballerFormDto footballerFormDto = FootballerFormDto.builder()
                .id(footballer.getId())
                .firstname(footballer.getFirstname())
                .lastname(footballer.getLastname())
                .salary(footballer.getSalary())
                .position(footballer.getPosition())
                .birthday(footballer.getBirthday())
                .build();

        if(footballer.getTeam() != null) {
            footballerFormDto.setTeamId(footballer.getTeam().getId());
        }
        return footballerFormDto;
    }

    private FootballerOfTeamDto mapToFootballerOfTeamDto(Footballer footballer)
    {
        return FootballerOfTeamDto.builder()
                .firstname(footballer.getFirstname())
                .lastname(footballer.getLastname())
                .id(footballer.getId())
                .build();
    }

    public List<FootballerOfTeamDto> getFootballerOfTeamDtoList(List<Footballer> footballers)
    {
        return footballers.stream()
                .map(this::mapToFootballerOfTeamDto)
                .collect(Collectors.toList());
    }

    public TeamViewFootballerDto mapToTeamViewDto(Footballer footballer){
        return TeamViewFootballerDto.builder()
                .teamId(footballer.getTeam().getId())
                .firstname(footballer.getFirstname())
                .lastname(footballer.getLastname())
                .position(footballer.getPosition())
                .build();
    }

    public List<TeamViewFootballerDto> getTeamViewDtoList(List<Footballer> footballers){
        return footballers.stream()
                .map(this::mapToTeamViewDto)
                .collect(Collectors.toList());
    }


}
