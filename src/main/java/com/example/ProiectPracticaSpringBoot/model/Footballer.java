package com.example.ProiectPracticaSpringBoot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor

@Entity
@Table(name = "footballer")

public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthday", columnDefinition = "DATE")
    private LocalDate birthday;

    @Column(name="salary")
    private int salary;

    @Column(name= "field_position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "id_team")
    private Team team;

}
