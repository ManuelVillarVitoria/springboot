package com.keepcoding.springboot.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserFilteredDto {
    private int id;
    private String name;
    @JsonIgnore
    private String password;

    public UserFilteredDto() {
    }

    public UserFilteredDto(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
