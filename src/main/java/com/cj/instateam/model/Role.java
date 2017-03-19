package com.cj.instateam.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name; // TODO:  CJ use enum class for this to validate data?

    @Column
    @OneToMany(mappedBy = "role") // many roles to one collaborator
    private List<Collaborator> collaborators = new ArrayList<>(); // TODO: CJ does this make sense?

    @Column
    @ManyToMany // many roles to many project
    private List<Project> projects = new ArrayList<>(); // TODO: CJ does this make sense?

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

    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<Collaborator> collaborators) {
        this.collaborators = collaborators;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
