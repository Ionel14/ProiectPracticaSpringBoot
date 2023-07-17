package com.example.ProiectPracticaSpringBoot.controller;

import com.example.ProiectPracticaSpringBoot.model.Footballer;
import com.example.ProiectPracticaSpringBoot.repository.FootballerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FootballersController {

    @Autowired
    FootballerRepository footballerRepository;
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
//        Footballer f1 = new Footballer(1, 1, "Gica",
//                "Hagi", LocalDate.of(1973, 11, 23), 23000, "CAM");
//        Footballer f2 = new Footballer(2, 1, "Ianis",
//                "Hagi", LocalDate.of(1997, 11, 23), 23000, "RW");
//        Footballer f3 = new Footballer(3, 1, "Lionel",
//                "Messi", LocalDate.of(1988, 11, 23), 63000, "RW");

        List<Footballer> footballer_database  = footballerRepository.findAll();
        model.addAttribute("footballer_database", footballer_database);

        return "footballers";
    }

    @GetMapping(value = "footballer-form")
    public String footballerForm(Model model) {
        model.addAttribute("new_footballer", new Footballer());
        return "footballer-form";
    }

    @PostMapping(value = "submit-footballer")
    public String submitFootballer(@ModelAttribute("new_footballer") Footballer new_footballer) {
       footballerRepository.save(new_footballer);
        return "redirect:/footballers";
    }
}
