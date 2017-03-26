package com.cj.instateam.model;

import javax.persistence.*;

@Entity
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne // many collaborators to one role
    private Role role;

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
