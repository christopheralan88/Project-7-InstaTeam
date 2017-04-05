package com.cj.instateam.web;

import com.cj.instateam.model.Role;
import com.cj.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String viewRoles(ModelMap model) {
        List<Role> roles = roleService.findAll();
        roles.stream().sorted((a, b) -> - a.getName().compareTo(b.getName()));
        model.put("role", new Role());
        model.put("roles", roles);
        return "roles";
    }

    @RequestMapping(value = "/roles", method = RequestMethod.POST, params = {"role_name"})
    public String addRole(@RequestParam(value = "role_name") String name) {
        Role role = new Role().setName(name);
        roleService.save(role);
        return "redirect:/roles";
    }

    @RequestMapping(value = "/edit_role/{id}", method = RequestMethod.POST)
    public String editRole(@PathVariable String id,
                           @RequestParam(value = "role_name") String name) {
        Role role = new Role().setId(Integer.parseInt(id))
                              .setName(name);
        roleService.save(role);
        return "redirect:/roles";
    }

    @RequestMapping(value = "/edit_role/{id}", method = RequestMethod.GET)
    public String viewEditRole(@PathVariable int id, ModelMap model) {
        Role role = roleService.findById(id);
        model.put("role", role);
        return "edit_role";
    }
}
