package com.example.ProiectPracticaSpringBoot.controller;

import com.example.ProiectPracticaSpringBoot.model.Footballer;
import com.example.ProiectPracticaSpringBoot.model.Team;
import com.example.ProiectPracticaSpringBoot.repository.FootballerRepository;
import com.example.ProiectPracticaSpringBoot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

import java.util.List;

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


}
