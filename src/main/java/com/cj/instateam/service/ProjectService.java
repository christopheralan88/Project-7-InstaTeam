package com.cj.instateam.service;


import com.cj.instateam.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project findById(int id);
    void save(Project project);
    void delete(Project project);
}
