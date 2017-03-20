package com.cj.instateam.service;


import com.cj.instateam.model.Role;

import java.util.List;


public interface RoleService {
    List<Role> findAll();
    Role findById(int id);
    void save(Role role);
    void delete(Role role);
}
