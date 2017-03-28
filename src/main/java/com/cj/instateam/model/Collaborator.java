package com.cj.instateam.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String name;

    @ManyToOne // many collaborators to one role
    @NotNull
    private Role role;

    /*@ManyToMany(mappedBy = "collaborators")
    private List<Project> projects;*/

    public Collaborator() {}

    public int getId() {
        return id;
    }

    public Collaborator setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Collaborator setName(String name) {
        this.name = name;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public Collaborator setRole(Role role) {
        this.role = role;
        return this;
    }
}
