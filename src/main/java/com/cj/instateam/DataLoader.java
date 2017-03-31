package com.cj.instateam;

import com.cj.instateam.dao.CollaboratorDao;
import com.cj.instateam.dao.ProjectDao;
import com.cj.instateam.dao.RoleDao;
import com.cj.instateam.model.Collaborator;
import com.cj.instateam.model.Project;
import com.cj.instateam.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    ProjectDao projectDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    CollaboratorDao collaboratorDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 1; i <= 5; i++) {

            // save roles
            Role role = new Role();
            role.setName("role " + i);
            roleDao.save(role);

            // save collaborators with one role each
            Collaborator collaborator = new Collaborator();
            collaborator.setName("collaborator " + i);
            collaborator.setRole(
                    roleDao.findById((int) i)
            );
            collaboratorDao.save(collaborator);

            // save projects with one role one collaborator each
            Project project = new Project();
            project.setName("project " + i);
            project.setDescription("description " + i);
            project.setStatus("status " + i);

            project.addRole(
                    roleDao.findById((int) i)
            );

            project.addCollaborator(
                    collaboratorDao.findById((int) i)
            );

            projectDao.save(project);
        }
    }
}
