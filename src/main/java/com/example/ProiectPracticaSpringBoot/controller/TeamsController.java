package com.example.ProiectPracticaSpringBoot.controller;

import com.example.ProiectPracticaSpringBoot.dto.TeamFormDto;
import com.example.ProiectPracticaSpringBoot.dto.TeamOverviewDto;
import com.example.ProiectPracticaSpringBoot.dto.TeamUpdateFormDto;
import com.example.ProiectPracticaSpringBoot.repository.FootballerRepository;
import com.example.ProiectPracticaSpringBoot.repository.TeamRepository;
import com.example.ProiectPracticaSpringBoot.service.FootballerService;
import com.example.ProiectPracticaSpringBoot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class TeamsController {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    FootballerRepository footballerRepository;

    @Autowired
    TeamService teamService;
    @Autowired
    FootballerService footballerService;

    @GetMapping(value = "/teamsOverview")
    public String teamsOverview(Model model) {

        List<TeamOverviewDto> teams_database = teamService.getTeamsOverview();
        model.addAttribute("teams", teams_database);

        return "teamsOverview";

    }

    @GetMapping(value = "/team-form")
    public String teamForm(Model model) {
        model.addAttribute("new_team", new TeamFormDto());
        return "team-form";
    }

    @PostMapping(value = "/submit-team")
    public String submitTeam(@ModelAttribute("new_team") TeamFormDto new_team) {
        teamService.saveTeam(new_team);
        return "redirect:/teamsOverview";
    }

    @GetMapping(value = "/delete-team")
    public String deleteTeam(@RequestParam("id") int team_id) {
        teamService.deleteTeam(team_id);
        return "redirect:/teamsOverview";
    }

    @PostMapping(value = "/team-update")
    public String footballerUpdate(@ModelAttribute("updated_team") TeamUpdateFormDto updated_team) {
        teamService.saveTeam(updated_team);
        return "redirect:/teamsOverview";
    }

    @GetMapping(value = "/team-update-form")
    public String teamUpdateForm(Model model, @RequestParam("id") int team_id) {

        model.addAttribute("team_to_be_updated", teamService.getTeamById(team_id));
        model.addAttribute("footballers", footballerService.getAllFootballersByTeamId(team_id));

        return "team-update-form";
    }
}
