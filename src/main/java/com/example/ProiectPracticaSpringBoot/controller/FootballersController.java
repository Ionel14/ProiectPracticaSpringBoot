package com.example.ProiectPracticaSpringBoot.controller;

import com.example.ProiectPracticaSpringBoot.model.Footballer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FootballersController {

    @GetMapping(value = "/")
    @ResponseBody
    public String printHello()
    {
        return "Hello Footballers, " +
                "to see the football players go to this path /footballers" +
                "to see the teams go to this path /teams";
    }

    @GetMapping(value = "/footballers")
    public String index(Model model)
    {
        Footballer f1 = new Footballer(1,"Gica",
                "Hagi", LocalDate.of(1973, 11,23), 23000, "CAM", 1);
        Footballer f2 = new Footballer(2,"Ianis",
                "Hagi", LocalDate.of(1997, 11,23), 23000, "RW", 2);
        Footballer f3 = new Footballer(3,"Lionel",
                "Messi", LocalDate.of(1988, 11,23), 63000, "RW", 1);

        List<Footballer> footballers = List.of(f1, f2, f3);
        model.addAttribute("footballers", footballers);

        return "footballers";
    }
}
