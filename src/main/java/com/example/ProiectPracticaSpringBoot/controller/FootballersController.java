package com.example.ProiectPracticaSpringBoot.controller;

import com.example.ProiectPracticaSpringBoot.model.Footballer;
import com.example.ProiectPracticaSpringBoot.model.Team;
import com.example.ProiectPracticaSpringBoot.repository.FootballerRepository;
import com.example.ProiectPracticaSpringBoot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FootballersController {

    @Autowired
    FootballerRepository footballerRepository;
    @Autowired
    TeamRepository teamRepository;
    private boolean once = true;

    @GetMapping(value = "/")
    @ResponseBody
    public String printHello() {
        return "Hello Footballers, " +
                "to see the football players go to this path /footballers" +
                "to see the teams go to this path /teams";
    }

    @GetMapping(value = "/footballers")
    public String index(Model model) {

        List<Footballer> footballer_database  = footballerRepository.findAll();
        model.addAttribute("footballer_database", footballer_database);

        return "footballers";
    }

    @GetMapping(value = "/footballer-form")
    public String footballerForm(Model model) {
        model.addAttribute("new_footballer", new Footballer());
        model.addAttribute("teams", teamRepository.findAll());
        return "footballer-form";
    }

    @PostMapping(value = "/submit-footballer")
    public String submitFootballer(@ModelAttribute("new_footballer") Footballer new_footballer) {
       footballerRepository.save(new_footballer);
        return "redirect:/footballers";
    }

    @PostMapping(value = "/footballer-update")
    public String footballerUpdate(@ModelAttribute("updated_footballer") Footballer updated_footballer) {
        footballerRepository.save(updated_footballer);
        return "redirect:/footballers";
    }

    @GetMapping(value = "/footballer-update-form")
    public String footballerUpdateForm(Model model, @RequestParam("id") int footballer_id){

        model.addAttribute("footballer_to_be_updated", footballerRepository.findById(footballer_id).get());
        model.addAttribute("teams", teamRepository.findAll());

        return "footballer-update-form";
    }

    @GetMapping(value = "/delete-footballer")
    public String deleteFootballer(@RequestParam("id") int footballer_id){

        Team team_of_footballer = teamRepository.findByFootballerId(footballer_id);
        if(team_of_footballer != null){
            team_of_footballer.setCaptain(null);
        }
        footballerRepository.deleteById(footballer_id);
        return "redirect:/footballers";
    }
}
