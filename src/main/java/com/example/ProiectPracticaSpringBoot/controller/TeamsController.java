package com.example.ProiectPracticaSpringBoot.controller;

import com.example.ProiectPracticaSpringBoot.model.Footballer;
import com.example.ProiectPracticaSpringBoot.model.Team;
import com.example.ProiectPracticaSpringBoot.repository.FootballerRepository;
import com.example.ProiectPracticaSpringBoot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TeamsController {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    FootballerRepository footballerRepository;

    // Hardcoded representations of database entities

    @GetMapping(value = "/teams")
    public String getTeams(Model model) {

        List<Team> teams_database = teamRepository.findAll();
        List<Footballer> footballers_database = footballerRepository.findAll();

        model.addAttribute("teams", teams_database);
        model.addAttribute("players", footballers_database);

        return "teams";

    }

    @GetMapping(value = "/team-form")
    public String teamForm(Model model) {
        model.addAttribute("new_team", new Team());
        return "team-form";
    }

    @PostMapping(value = "/submit-team")
    public String submitTeam(@ModelAttribute("new_team") Team new_team) {
        teamRepository.save(new_team);
        return "redirect:/teams";
    }

    @GetMapping(value = "/delete-team")
    public String deleteTeam(@RequestParam("id") int team_id){
        List<Footballer> footballers_of_certain_team = footballerRepository.findByTeamId(team_id);
        for(Footballer f : footballers_of_certain_team){
            f.setTeam(null);
            footballerRepository.save(f);
        }
        teamRepository.deleteById(team_id);

        return "redirect:/teams";
    }

    @PostMapping(value = "/team-update")
    public String footballerUpdate(@ModelAttribute("updated_team") Team updated_team) {
        teamRepository.save(updated_team);
        return "redirect:/teams";
    }

    @GetMapping(value = "/team-update-form")
    public String teamUpdateForm(Model model, @RequestParam("id") int team_id){

        model.addAttribute("team_to_be_updated", teamRepository.findById(team_id).get());
        model.addAttribute("footballers", footballerRepository.findByTeamId(team_id));

        return "team-update-form";
    }
}
