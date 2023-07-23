package com.example.ProiectPracticaSpringBoot.service;

import com.example.ProiectPracticaSpringBoot.dto.TeamFormDto;
import com.example.ProiectPracticaSpringBoot.dto.TeamOfFootballerDto;
import com.example.ProiectPracticaSpringBoot.dto.TeamOverviewDto;
import com.example.ProiectPracticaSpringBoot.dto.TeamUpdateFormDto;
import com.example.ProiectPracticaSpringBoot.mapper.TeamMapper;
import com.example.ProiectPracticaSpringBoot.model.Footballer;
import com.example.ProiectPracticaSpringBoot.model.Team;
import com.example.ProiectPracticaSpringBoot.repository.FootballerRepository;
import com.example.ProiectPracticaSpringBoot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    FootballerRepository footballerRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TeamMapper teamMapper;

    public List<TeamOverviewDto> getTeamsOverview() {
        return teamMapper.getTeamDtoList(teamRepository.findAll());
    }

    public List<TeamOfFootballerDto> getTeamsOfFootballerForm(){
        return teamMapper.getTeamOfFootballerDto(teamRepository.findAll());
    }

    public void saveTeam(TeamFormDto team){
        teamRepository.save(teamMapper.mapToTeam(team));
    }

    public void saveTeam(TeamUpdateFormDto team) {
        teamRepository.save(teamMapper.mapToTeam(team));
    }

    public void deleteTeam(int team_id){
        List<Footballer> footballers_of_certain_team = footballerRepository.findByTeamId(team_id);
        for (Footballer f : footballers_of_certain_team) {
            f.setTeam(null);
            footballerRepository.save(f);
        }
        teamRepository.deleteById(team_id);
    }

    public Team getTeamById(int team_id){
        return teamRepository.getReferenceById(team_id);
    }


}
