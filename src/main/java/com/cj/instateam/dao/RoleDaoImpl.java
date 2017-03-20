package com.cj.instateam.dao;


import com.cj.instateam.model.Role;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository  // Don't need constructor because @Repository creates bean for you?
public class RoleDaoImpl implements RoleDao{
    @Autowired
    private SessionFactory sessionFactory; // LocalSessionFactoryBean returned from sessionFactory()
    // method in DataConfig class is eligible for DI for this field b/c it implements FactoryBean<SessionFactory>

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        Session session = sessionFactory.openSession();
        List<Role> roles = session.createCriteria(Role.class).list();
        session.close();
        return roles;
    }

    @Override
    public Role findById(int id) {
        Session session = sessionFactory.openSession();
        Role role = session.get(Role.class, id);
        Hibernate.initialize(role.getName());
        session.close();
        return role;
    }

    @Override
    public void save(Role role) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(role);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Role role) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(role);
        session.getTransaction().commit();
        session.close();
    }

}
