package com.example.ProiectPracticaSpringBoot.service;

import com.example.ProiectPracticaSpringBoot.dto.FootballerFormDto;
import com.example.ProiectPracticaSpringBoot.dto.FootballerOverviewDto;
import com.example.ProiectPracticaSpringBoot.mapper.FootballerMapper;
import com.example.ProiectPracticaSpringBoot.model.Footballer;
import com.example.ProiectPracticaSpringBoot.model.Team;
import com.example.ProiectPracticaSpringBoot.repository.FootballerRepository;
import com.example.ProiectPracticaSpringBoot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FootballerService {

    @Autowired
    FootballerRepository footballerRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    FootballerMapper footballerMapper;

    public List<FootballerOverviewDto> getFootballersOverview()
    {
        return footballerMapper.getFootballerDtoList(footballerRepository.findAll());
    }

    public void saveFootballer(FootballerFormDto footballerFormDto)
    {
        Footballer footballer = footballerMapper.mapToFootballer(footballerFormDto);
        footballerRepository.save(footballer);
        if (footballerFormDto.getIsCaptain())
        {
            Optional<Team> team = teamRepository.findById(footballerFormDto.getTeamId());
            team.get().setCaptain(footballer);
            teamRepository.save(team.get());
        }
    }

    public FootballerFormDto getFootballerById(int id)
    {
        return footballerMapper.mapToFootballerFormDto(footballerRepository.findById(id).get());
    }

    public void deleteFootballer(int footballer_id)
    {
        Footballer footballer = footballerRepository.getReferenceById(footballer_id);
        Team team_of_footballer = teamRepository.findByFootballerId(footballer_id);
        if(team_of_footballer != null){
            List<Footballer> footballerList = team_of_footballer.getPlayers();
            footballerList.remove(footballer);

            if (team_of_footballer.getCaptain() == footballer)
            {
                team_of_footballer.setCaptain(null);
            }

            teamRepository.save(team_of_footballer);
        }
        footballerRepository.deleteById(footballer_id);
    }
}
