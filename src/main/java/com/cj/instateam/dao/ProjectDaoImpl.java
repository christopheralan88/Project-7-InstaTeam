package com.cj.instateam.dao;

import com.cj.instateam.model.Collaborator;
import com.cj.instateam.model.Project;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> findAll() {
        Session session = sessionFactory.openSession();
        List<Project> projects = session.createCriteria(Project.class).list();
        for (Project project : projects) {
            Hibernate.initialize(project.getName());
            Hibernate.initialize(project.getCollaborators());
            Hibernate.initialize(project.getRolesNeeded());
        }
        session.close();
        return projects;
    }

    @Override
    public Project findById(int id) {
        Session session = sessionFactory.openSession();
        Project project = session.get(Project.class, id);
        Hibernate.initialize(project.getName());
        Hibernate.initialize(project.getCollaborators());
        Hibernate.initialize(project.getRolesNeeded());
        session.close();
        return project;
    }

    @Override
    public List<Integer> projectCollaborators (int id) {
        Session session = sessionFactory.openSession();
        String hql = String.format("FROM PROJECT_ROLE WHERE PROJECT_ID = %d", id);
        Query query = session.createQuery(hql);
        List<Integer> roleIds= query.list();
        return roleIds;
    }

    @Override
    public void save(Project project) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(project);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Project project) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(project);
        session.getTransaction().commit();
        session.close();
    }
}
