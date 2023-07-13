package com.example.ProiectPracticaSpringBoot.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Team {

    private int teamId;
    private String name;
    private List<Footballer> players;
    private String location;
    private LocalDate foundationDate;
    private String coach;
    private Footballer captain;
    private String leagueName;

    /*All args constructor with empty list*/
    public Team(int teamId, String name, String location, LocalDate foundationDate, String coachName, Footballer captain, String leagueName) {
        this.teamId = teamId;
        this.name = name;
        this.location = location;
        this.foundationDate = foundationDate;
        this.coach = coachName;
        this.captain = captain;
        this.leagueName = leagueName;
        this.players = new ArrayList<>();
    }

    public void addFootballer(Footballer new_footballer) {
        this.players.add(new_footballer);
    }

    public String getCaptainFirstName() {
        if (captain == null) {
            return "N/A";
        }
        return this.captain.getFirstname();
    }

    public String getCaptainLastName() {
        if (captain == null) {
            return "";
        }
        return this.captain.getLastname();
    }

    public int getPlayersCount() {
        if (this.players == null) {
            return 0;
        }
        return this.players.size();
    }
}
