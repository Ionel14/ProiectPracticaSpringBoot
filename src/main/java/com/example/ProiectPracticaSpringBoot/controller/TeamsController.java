package com.example.ProiectPracticaSpringBoot.controller;

import com.example.ProiectPracticaSpringBoot.model.Footballer;
import com.example.ProiectPracticaSpringBoot.model.Team;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TeamsController {

    // Hardcoded representations of database entities
    private List<Footballer> footballers_database = new ArrayList<>();
    private List<Team> teams_database = new ArrayList<>();

    @GetMapping(value = "/teams")
    public String getTeams(Model model){

            Footballer SergioRamos = new Footballer(1, "Sergio", "Ramos",
                    LocalDate.of(1986,3,30), 40000, "DF",1);

            Footballer KarimBenzema = new Footballer(2,"Karim", "Benzema",
                    LocalDate.of(1987,12,19),35000, "FW", 1);

            Footballer SergioBusquets = new Footballer(3, "Sergio", "Busquets",
                    LocalDate.of(1988,7,16), 42000,"MF",2);

            Footballer FrenkieDeJong = new Footballer(4,"Frenkie", "De Jong",
                    LocalDate.of(1997,5,12), 37000, "MF", 2);

            footballers_database.add(SergioBusquets);
            footballers_database.add(KarimBenzema);
            footballers_database.add(SergioRamos);
            footballers_database.add(FrenkieDeJong);

            Team real_madrid = new Team(1, "Real Madrid FC","Madrid, Spain",
                   LocalDate.of(1902,3,6), "Carlo Ancelotti", SergioRamos, "La Liga");
            Team barcelona = new Team(2, "Barcelona FC", "Barcelona, Catalonia, Spain",
                    LocalDate.of(1899,11,29), "Xavi Hernandez", SergioBusquets, "La Liga");

            teams_database.add(real_madrid);
            teams_database.add(barcelona);

            for(Footballer player : footballers_database){
                for(Team team : teams_database){
                    if(player.getTeamId() == team.getTeamId()){
                        team.addFootballer(player);
                    }
                }
            }

            model.addAttribute("teams", teams_database);
            model.addAttribute("players",footballers_database);
            
        return "teams";

    }
}
