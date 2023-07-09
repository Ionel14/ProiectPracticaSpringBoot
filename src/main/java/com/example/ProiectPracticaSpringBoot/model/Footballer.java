package com.example.ProiectPracticaSpringBoot.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Footballer {

    private int id;
    private int teamId;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private int salary;
    private String position;

    public Footballer(int id, String firstname, String lastname, LocalDate birthday, int salary, String position, int teamId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.salary = salary;
        this.position = position;
        this.teamId = teamId;
    }

}
