package com.example.ProiectPracticaSpringBoot.controller;

import com.example.ProiectPracticaSpringBoot.dto.TeamFormDto;
import com.example.ProiectPracticaSpringBoot.dto.TeamOverviewDto;
import com.example.ProiectPracticaSpringBoot.dto.TeamUpdateFormDto;
import com.example.ProiectPracticaSpringBoot.repository.FootballerRepository;
import com.example.ProiectPracticaSpringBoot.repository.TeamRepository;
import com.example.ProiectPracticaSpringBoot.service.FootballerService;
import com.example.ProiectPracticaSpringBoot.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class ,stringTrimmerEditor);
    }

    @GetMapping(value = "/teamsOverview")
    public String teamsOverview(Model model) {
        model.addAttribute("teams",  teamService.getTeamsOverview());
        return "teamsOverview";
    }

    @GetMapping(value = "/team-form")
    public String teamForm(Model model) {
        model.addAttribute("new_team", new TeamFormDto());
        return "team-form";
    }

    @PostMapping(value = "/submit-team")
    public String submitTeam(@ModelAttribute("new_team")  @Valid TeamFormDto new_team,
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("new_footballer", new_team);
            return "team-form";
        }
        teamService.saveTeam(new_team);
        return "redirect:/teamsOverview";
    }

    @PostMapping(value = "/team-update")
    public String teamUpdate(@ModelAttribute("team_to_be_updated") @Valid TeamUpdateFormDto team_to_be_updated,
                                   BindingResult bindingResult,
                                   Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("team_to_be_updated", team_to_be_updated);
            model.addAttribute("footballers", footballerService.getAllFootballerOfTeamDtoList(team_to_be_updated.getId()));
            return "team-update-form";
        }
        teamService.saveTeam(team_to_be_updated);
        return "redirect:/teamsOverview";
    }

    @GetMapping(value = "/team-update-form")
    public String teamUpdateForm(Model model, @RequestParam("id") int team_id) {

        model.addAttribute("team_to_be_updated", teamService.getTeamUpdateFormDtoById(team_id));
        model.addAttribute("footballers", footballerService.getAllFootballerOfTeamDtoList(team_id));

        return "team-update-form";
    }

    @GetMapping(value = "/delete-team")
    public String deleteTeam(@RequestParam("id") int team_id) {
        teamService.deleteTeam(team_id);
        return "redirect:/teamsOverview";
    }

    @GetMapping(value = "/view-team")
    public String viewTeam(Model model,
                           @RequestParam("id") int team_id){
        model.addAttribute("team", teamService.getTeamViewDto(team_id));
        model.addAttribute("footballers", footballerService.teamViewFootballers(team_id));
        return "team-view";
    }
}


