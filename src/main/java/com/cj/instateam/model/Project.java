package com.cj.instateam.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull(message = "You must enter a name")
    private String name;

    @Column
    @Size(min = 1)
    @NotNull(message = "You must enter a description")
    private String description;

    @Column
    @NotNull(message = "You must choose a status")
    private String status;

    public void setCollaborators(List<Collaborator> collaborators) {
        this.collaborators = collaborators;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Role> rolesNeeded = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
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

    // methods

    public void addRole(Role role) {
        rolesNeeded.add(role);
    }

    public void addCollaborator(Collaborator collaborator) {
        collaborators.add(collaborator);
    }

    // overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        if (description != null ? !description.equals(project.description) : project.description != null) return false;
        if (status != null ? !status.equals(project.status) : project.status != null) return false;
        if (rolesNeeded != null ? !rolesNeeded.equals(project.rolesNeeded) : project.rolesNeeded != null) return false;
        return collaborators != null ? collaborators.equals(project.collaborators) : project.collaborators == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (rolesNeeded != null ? rolesNeeded.hashCode() : 0);
        result = 31 * result + (collaborators != null ? collaborators.hashCode() : 0);
        return result;
    }
}