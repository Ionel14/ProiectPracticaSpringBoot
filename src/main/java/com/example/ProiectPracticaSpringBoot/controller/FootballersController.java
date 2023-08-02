package com.example.ProiectPracticaSpringBoot.controller;

import com.example.ProiectPracticaSpringBoot.dto.FootballerFormDto;

import com.example.ProiectPracticaSpringBoot.service.FootballerService;
import com.example.ProiectPracticaSpringBoot.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class FootballersController  extends BaseController{

    @Autowired
    FootballerService footballerService;

    @Autowired
    TeamService teamService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class ,stringTrimmerEditor);
    }

    @GetMapping(value = "/home")
    public String home(Model model, Authentication authentication) {
        addUserToModel(model, authentication);
        return "index";
    }

    @GetMapping(value = "/footballers")
    public String footballersTable(Model model, Authentication authentication) {
        addUserToModel(model, authentication);
        model.addAttribute("footballer_database", footballerService.getFootballersOverview());
        return "footballers";
    }

    @GetMapping(value = "/footballer-form")
    public String footballerForm(Model model, Authentication authentication) {
        addUserToModel(model, authentication);
        model.addAttribute("new_footballer", new FootballerFormDto());
        //model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("isCaptain", false);
        model.addAttribute("teams", teamService.getTeamsOfFootballerForm());

        return "footballer-form";
    }

    @PostMapping(value = "/submit-footballer")
    public String submitFootballer(@ModelAttribute("new_footballer") @Valid FootballerFormDto new_footballer,
                                   BindingResult bindingResult,
                                   @RequestParam(value = "isCaptain", required = false) boolean isCaptain,
                                   Model model, Authentication authentication) {
        addUserToModel(model, authentication);
        if (bindingResult.hasErrors())
        {
            model.addAttribute("new_footballer", new_footballer);
            model.addAttribute("isCaptain", isCaptain);
            model.addAttribute("teams", teamService.getTeamsOfFootballerForm());
            return "footballer-form";
        }
        footballerService.saveFootballer(new_footballer, isCaptain);
        return "redirect:/footballers";
    }

    @GetMapping(value = "/footballer-update-form")
    public String footballerUpdateForm(@RequestParam("id") int footballer_id, Model model, Authentication authentication) {
        addUserToModel(model, authentication);

        model.addAttribute("footballer_to_be_updated", footballerService.getFootballerById(footballer_id));
        model.addAttribute("teams", teamService.getTeamsOfFootballerForm());

        return "footballer-update-form";
    }

    @PostMapping(value = "/footballer-update")
    public String footballerUpdate(@ModelAttribute("footballer_to_be_updated") @Valid FootballerFormDto updated_footballer,
                                   BindingResult bindingResult, Model model, Authentication authentication) {
        addUserToModel(model, authentication);
        if (bindingResult.hasErrors())
        {
            model.addAttribute("footballer_to_be_updated", updated_footballer);
            model.addAttribute("teams", teamService.getTeamsOfFootballerForm());
            return "footballer-update-form";
        }
        footballerService.saveFootballer(updated_footballer, false);
        return "redirect:/footballers";
    }

    @GetMapping(value = "/delete-footballer")
    public String deleteFootballer(@RequestParam("id") int footballer_id, Model model, Authentication authentication) {
        addUserToModel(model, authentication);

        footballerService.deleteFootballer(footballer_id);
        return "redirect:/footballers";
    }
}
