package com.example.ProiectPracticaSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
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

    public void addFootballer(Footballer new_footballer){
        this.players.add(new_footballer);
    }

    public int getPlayersCount(){
        return this.players.size();
    }

}
