package com.epam.testtask.controller;

import com.epam.testtask.model.Project;
import com.epam.testtask.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectRepository repository;

    @Autowired
    public void setRepository(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/list")
    public String getAll(Model model, HttpSession session) {
        List<Project> projects = repository.getAll();
        model.addAttribute("projects", projects);
        session.setAttribute("allProjects", projects);
        return "projects/projects-list";
    }

    @GetMapping("/addProjectForm")
    public String addProjectForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "projects/add-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ("project") Project project) {
        //forcing to save new (not update)
        project.setId(0);
        repository.save(project);

        //post-redirect-get
        return "redirect:/projects/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("projectId") int projectId) {
        repository.delete(projectId);
        return "redirect:/projects/list";
    }
}
