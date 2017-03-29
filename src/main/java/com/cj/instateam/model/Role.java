package com.cj.instateam.model;


import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role") // many roles to one collaborator...mappedby means
    // this field is mapped to role field of collaborators entity/table?
    private List<Collaborator> collaborators = new ArrayList<>();

    /*@ManyToMany(mappedBy = "rolesNeeded")
    private List<Project> projects = new ArrayList<>();*/

    public Role() {}

    public int getId() {
        return id;
    }

    public Role setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<Collaborator> collaborators) {
        this.collaborators = collaborators;
    }
}
