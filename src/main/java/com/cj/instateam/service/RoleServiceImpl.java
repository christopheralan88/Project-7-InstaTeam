package com.cj.instateam.service;


import com.cj.instateam.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl {
    @Autowired
    private RoleDao roleDao;

}
