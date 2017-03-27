package com.cj.instateam.dao;


import com.cj.instateam.model.Collaborator;
import com.cj.instateam.model.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> findAll();
    Project findById(int id);
    List<Integer> projectCollaborators (int id);
    void save(Project project);
    void delete(Project project);
}
