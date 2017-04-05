package com.cj.instateam.web;

import com.cj.instateam.model.Collaborator;
import com.cj.instateam.model.Role;
import com.cj.instateam.service.CollaboratorService;
import com.cj.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        model.put("collaborator", new Collaborator());
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

    @RequestMapping(value = "/collaborators", method = RequestMethod.POST)
    public String addCollaborator(@Valid Collaborator collaborator, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", "Please fill out the form completely");
            redirectAttributes.addFlashAttribute("collaborator", collaborator);
            return "redirect:/errors";
        }
        collaboratorService.save(collaborator);
        return "redirect:/collaborators";
    }

}
