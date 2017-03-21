package com.cj.instateam.web;

import com.cj.instateam.model.Project;
import com.cj.instateam.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

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
    public String displayAddProjectForm() {
        return "add_project";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addProject(@RequestParam(value = "name") String name,
                             @RequestParam(value = "description") String description,
                             @RequestParam(value = "status") String status,
                             ModelMap model) {
        Project project = new Project()
                              .setName(name)
                              .setDescription(description)
                              .setStatus(status);
        projectService.save(project); // TODO:  CJ wrap this in try-catch block.
        return "redirect:/";
    }


}
