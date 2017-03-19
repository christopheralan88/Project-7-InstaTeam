package com.cj.instateam.dao;


import com.cj.instateam.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();
    Role findById(int id);
    void save(Role role);
    void delete(Role role);
}
