package com.example.ProiectPracticaSpringBoot.mapper;

import com.example.ProiectPracticaSpringBoot.dto.TeamFormDto;
import com.example.ProiectPracticaSpringBoot.dto.TeamOfFootballerDto;
import com.example.ProiectPracticaSpringBoot.dto.TeamOverviewDto;
import com.example.ProiectPracticaSpringBoot.dto.TeamUpdateFormDto;
import com.example.ProiectPracticaSpringBoot.model.Footballer;
import com.example.ProiectPracticaSpringBoot.model.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMapper {
    public List<TeamOverviewDto> getTeamDtoList(List<Team> teams) {
        return teams.stream()
                .map(team -> mapToTeamOverviewDto(team))
                .collect(Collectors.toList());
    }

    private TeamOverviewDto mapToTeamOverviewDto(Team team) {
        return TeamOverviewDto.builder()
                .id(team.getId())
                .captainName(team.getCaptainFirstName() + ' ' + team.getCaptainLastName())
                .coach(team.getCoach())
                .foundationDate(team.getFoundationDate())
                .leagueName(team.getLeagueName())
                .location(team.getLocation())
                .name(team.getName())
                .playerCount(team.getPlayersCount())
                .build();
    }

    public Team mapToTeam(TeamFormDto team){

        return Team.builder()
                .coach(team.getCoach())
                .leagueName(team.getLeagueName())
                .name(team.getName())
                .foundationDate(team.getFoundationDate())
                .location(team.getLocation())
                .build();

    }

    public Team mapToTeam(TeamUpdateFormDto team){

        return Team.builder()
                .coach(team.getCoach())
                .leagueName(team.getLeagueName())
                .name(team.getName())
                .foundationDate(team.getFoundationDate())
                .location(team.getLocation())
                .id(team.getId())
                .captain(team.getCaptain())
                .build();
    }

    public List<TeamOfFootballerDto> getTeamOfFootballerDto(List<Team> teams){
        return teams.stream()
                .map(team -> mapToTeamOfFootballerDto(team))
                .collect(Collectors.toList());
    }

    private TeamOfFootballerDto mapToTeamOfFootballerDto(Team team) {
        return TeamOfFootballerDto.builder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }

    public TeamUpdateFormDto mapToTeamUpdateFormDto(Team team){
        return TeamUpdateFormDto.builder()
                .coach(team.getCoach())
                .foundationDate(team.getFoundationDate())
                .leagueName(team.getLeagueName())
                .location(team.getLocation())
                .name(team.getName())
                .id(team.getId())
                .captain(team.getCaptain())
                .build();
    }
}
