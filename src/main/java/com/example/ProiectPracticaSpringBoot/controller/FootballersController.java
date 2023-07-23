package com.example.ProiectPracticaSpringBoot.controller;

import com.example.ProiectPracticaSpringBoot.dto.FootballerFormDto;

import com.example.ProiectPracticaSpringBoot.service.FootballerService;
import com.example.ProiectPracticaSpringBoot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FootballersController {

    @Autowired
    FootballerService footballerService;

    @Autowired
    TeamService teamService;

    @GetMapping(value = "/")
    public String homePage() {
        return "index";
    }

    @GetMapping(value = "/footballers")
    public String footballersTable(Model model) {
        model.addAttribute("footballer_database", footballerService.getFootballersOverview());
        return "footballers";
    }

    @GetMapping(value = "/footballer-form")
    public String footballerForm(Model model) {
        model.addAttribute("new_footballer", new FootballerFormDto());
        //model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("teams", teamService.getTeamsOfFootballerForm());

        return "footballer-form";
    }

    @PostMapping(value = "/submit-footballer")
    public String submitFootballer(@ModelAttribute("new_footballer") FootballerFormDto new_footballer){
       footballerService.saveFootballer(new_footballer);
        return "redirect:/footballers";
    }

    @GetMapping(value = "/footballer-update-form")
    public String footballerUpdateForm(Model model, @RequestParam("id") int footballer_id) {

        model.addAttribute("footballer_to_be_updated", footballerService.getFootballerById(footballer_id));
        model.addAttribute("teams", teamService.getTeamsOfFootballerForm());

        return "footballer-update-form";
    }

    @PostMapping(value = "/footballer-update")
    public String footballerUpdate(@ModelAttribute("updated_footballer") FootballerFormDto updated_footballer) {
        footballerService.saveFootballer(updated_footballer);
        return "redirect:/footballers";
    }

    @GetMapping(value = "/delete-footballer")
    public String deleteFootballer(@RequestParam("id") int footballer_id) {

        footballerService.deleteFootballer(footballer_id);
        return "redirect:/footballers";
    }
}
