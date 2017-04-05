package com.cj.instateam.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    @Size(min = 1)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Collaborator that = (Collaborator) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return role != null ? role.equals(that.role) : that.role == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}