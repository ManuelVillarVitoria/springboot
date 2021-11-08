package com.keepcoding.springboot.model;

import org.hibernate.annotations.BatchSize;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class Hero {

    private int id;
    @Size(min = 3, message = "El tamaño debe ser mayor que 2")
    private String name;
    private String heroName;
    @Past
    private Date birthdate;

    public Hero() {
    }

    public Hero(int id, String name, String heroName, Date birthdate) {
        this.id = id;
        this.name = name;
        this.heroName = heroName;
        this.birthdate = birthdate;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
