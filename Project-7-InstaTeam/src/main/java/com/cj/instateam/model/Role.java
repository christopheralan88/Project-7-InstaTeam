package com.cj.instateam.model;


import javax.persistence.*;
import java.util.List;

@Entity(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name; // TODO:  CJ use enum class for this to validate data?

    @ManyToOne // many roles to one collaborator
    private Collaborator collaborator; // TODO: CJ does this make sense?

    @ManyToOne // many roles to one project
    private Project project; // TODO: CJ does this make sense?

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
