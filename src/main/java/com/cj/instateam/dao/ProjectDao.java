package com.cj.instateam.dao;


import com.cj.instateam.model.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> findAll(int id);
    Project findById();
    void save(Project project);
    void delete(Project project);
}
