package com.cj.instateam.dao;


import com.cj.instateam.model.Collaborator;

import java.util.List;

public interface CollaboratorDao {
    List<Collaborator> findAll();
    Collaborator findById(int id);
    void save(Collaborator collaborator);
    void delete(Collaborator collaborator);
}
