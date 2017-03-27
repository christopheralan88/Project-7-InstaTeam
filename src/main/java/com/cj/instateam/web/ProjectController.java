package com.cj.instateam.web;

import com.cj.instateam.model.Collaborator;
import com.cj.instateam.model.Project;
import com.cj.instateam.model.Role;
import com.cj.instateam.service.CollaboratorService;
import com.cj.instateam.service.ProjectService;
import com.cj.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CollaboratorService collaboratorService;

    @RequestMapping(value = {"/", "/projects"}, method = RequestMethod.GET)
    public String listProjects(Model model) {
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "index";
    }

    @RequestMapping(value = "/project-detail/{id}", method = RequestMethod.GET)
    public String viewProjectDetail(@PathVariable int id, ModelMap model) {
        Project project = projectService.findById(id);
        model.put("project", project);
        return "project_detail";
    }

    @RequestMapping(value = "/add_project", method = RequestMethod.GET)
    public String displayAddProjectForm(ModelMap model) {
        List<Role> roles = roleService.findAll();
        List<Collaborator> collaborators = collaboratorService.findAll();
        model.put("roles", roles);
        model.put("collaborators", collaborators);
        return "add_project";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addProject(@RequestParam(value = "name") String name,
                             @RequestParam(value = "description") String description,
                             @RequestParam(value = "status") String status,
                             @RequestParam(value = "roles_needed", required = false) List<String> rolesNeededIds,
                             ModelMap model) {
        List<Role> rolesNeeded = new ArrayList<>();
        for (String roleId : rolesNeededIds) {
            rolesNeeded.add(roleService.findById(Integer.parseInt(roleId)));
        }
        Project project = new Project()
                              .setName(name)
                              .setDescription(description)
                              .setStatus(status)
                              .setRolesNeeded(rolesNeeded);
        projectService.save(project); // TODO:  CJ wrap this in try-catch block.
        return "redirect:/";
    }

    @RequestMapping(value = "/edit_project/{id}", method = RequestMethod.GET)
    public String viewEditProject(@PathVariable int id, ModelMap model) {
        Project project = projectService.findById(id);
        model.put("project", project);
        return "edit_project";
    }

    @RequestMapping(value = "/edit_project/{id}", method = RequestMethod.POST)
    public String editProject(@PathVariable int id,
                              @RequestParam(value = "project_name") String name,
                              @RequestParam(value = "project_description") String description,
                              @RequestParam(value = "project_status") String status,
                              ModelMap model) {
        Project project = new Project().setId(id)
                                       .setName(name)
                                       .setDescription(description)
                                       .setStatus(status);
        projectService.save(project);
        return "redirect:/project-detail/{id}";
    }

    @RequestMapping(value = "/project_collaborators/{projectId}", method = RequestMethod.GET)
    public String editProjectCollaborators(@PathVariable(value = "projectId") String projectId,
                                           ModelMap model) {
        //Project project = projectService.findById(Integer.parseInt(projectId));
        List<Integer> projectRoleIds = projectService.projectCollaborators(Integer.parseInt(projectId));
        List<Role> projectRoles = new ArrayList<>();
        for (Integer projectRoleId : projectRoleIds) {
            projectRoles.add(roleService.findById(projectRoleId));
        }
        List<Collaborator> collaborators = collaboratorService.findAll();
        //model.put("project", project);
        model.put("roles", projectRoles);
        model.put("collaborators", collaborators);
        return "project_collaborators";
    }

}
