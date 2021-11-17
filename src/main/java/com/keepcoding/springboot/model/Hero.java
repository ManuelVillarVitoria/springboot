package com.keepcoding.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "")
    private int id;
    @Size(min = 3, message = "El tamaño debe ser mayor que 2")
    private String name;
    private String heroName;
    @Past
    private Date birthDate;

    public Hero() {
    }

    public Hero(int id, String name, String heroName, Date birthDate) {
        this.id = id;
        this.name = name;
        this.heroName = heroName;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthdate) {
        this.birthDate = birthDate;
    }
}
