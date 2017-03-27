package com.cj.instateam.web;

import com.cj.instateam.model.Collaborator;
import com.cj.instateam.model.Role;
import com.cj.instateam.service.CollaboratorService;
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
public class CollaboratorController {
    @Autowired
    private CollaboratorService collaboratorService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/collaborators", method = RequestMethod.GET)
    public String viewCollaborators(ModelMap model) {
        List<Collaborator> collaborators = collaboratorService.findAll();
        List<Role> roles = roleService.findAll();
        model.put("collaborators", collaborators);
        model.put("roles", roles);
        return "collaborators";
    }

    @RequestMapping(value = "/collaborators/edit/{id}", method = RequestMethod.GET)
    public String viewEditCollaborators(@PathVariable(value = "id") String id,
                                        ModelMap model) {
        Collaborator collaborator = collaboratorService.findById(Integer.parseInt(id));
        List<Role> roles = roleService.findAll();
        model.put("collaborator", collaborator);
        model.put("roles", roles);
        return "edit_collaborators";
    }

    /*@RequestMapping(value = "/edit_collaborator/{id}", method = RequestMethod.POST)
    public String addCollaborator(@PathVariable(value = "id") String id) // collaborator id
    //@RequestParam(value = "collaborator_name") String collaboratorName,
    //@RequestParam(value = "role") String roleId)
    {
        Role role = roleService.findById(Integer.parseInt(id));
        Collaborator collaborator = new Collaborator().setId(Integer.parseInt(id))
                .setName(id)
                .setRole(role);
        collaboratorService.save(collaborator);
        return "redirect:/collaborators";
    }*/

    @RequestMapping(value = "/edit_collaborator/{id}", method = RequestMethod.POST)
    public String editCollaborators(@PathVariable(value = "id") String id, // collaborator id
                                    @RequestParam(value = "collaborator_name") String collaboratorName,
                                    @RequestParam(value = "role_name") String roleId) {
        Role role = roleService.findById(Integer.parseInt(roleId));
        Collaborator collaborator = new Collaborator().setId(Integer.parseInt(id))
                                                      .setName(collaboratorName)
                                                      .setRole(role);
        collaboratorService.save(collaborator);
        return "redirect:/collaborators";
    }

    @RequestMapping(value = "/collaborators", method = RequestMethod.POST)
    public String addCollaborator(@RequestParam(value = "collaborator_name") String name,
                                  @RequestParam(value = "role_name") String roleId) {
        Role role = roleService.findById(Integer.parseInt(roleId));
        Collaborator collaborator = new Collaborator().setName(name).setRole(role);
        collaboratorService.save(collaborator);
        return "redirect:/collaborators";
    }

}
