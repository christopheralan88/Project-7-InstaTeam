package com.cj.instateam.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String description;

    @Column
    @NotNull
    private String status;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "PROJECT_ROLE",
               joinColumns = @JoinColumn(name = "PROJECT_ID"),
               inverseJoinColumns = @JoinColumn(name = "ROLESNEEDED_ID"))
    private List<Role> rolesNeeded = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "PROJECT_COLLABORATOR",
               joinColumns = @JoinColumn(name = "PROJECT_ID"),
               inverseJoinColumns = @JoinColumn(name = "COLLABORATORS_ID"))
    private List<Collaborator> collaborators = new ArrayList<>();

    public Project() {}

    public int getId() {
        return id;
    }

    public Project setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Project setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<Role> getRolesNeeded() {
        return rolesNeeded;
    }

    public Project setRolesNeeded(List<Role> rolesNeeded) {
        this.rolesNeeded = rolesNeeded;
        return this;
    }

    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

    public Project setCollaborators(List<Collaborator> collaborators) {
        this.collaborators = collaborators;
        return this;
    }
}
