package com.cj.instateam.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    @ManyToOne // many to collaborators to one role
    private Role role;

    @Column
    @ManyToMany
    private List<Project> projects;

    public Collaborator() {}

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
