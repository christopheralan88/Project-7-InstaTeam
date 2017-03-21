package com.cj.instateam.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String status;

    @ManyToMany
    private List<Role> rolesNeeded = new ArrayList<>();

    @ManyToMany
    private List<Collaborator> collaborators;

    public Project() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
