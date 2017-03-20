package com.cj.instateam.service;


import com.cj.instateam.model.Collaborator;

import java.util.List;

public interface CollaboratorService {
    List<Collaborator> findAll();
    Collaborator findById(int id);
    void save(Collaborator collaborator);
    void delete(Collaborator collaborator);
}
