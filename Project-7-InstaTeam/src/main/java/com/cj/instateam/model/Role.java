package com.cj.instateam.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "role")
public class Role {

    @Id
    private int id;

    @Column
    private String name; // TODO:  CJ use enum class for this to validate data?

    public Role() {}

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
}
