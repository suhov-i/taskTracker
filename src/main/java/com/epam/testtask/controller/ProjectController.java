package com.epam.testtask.controller;

import com.epam.testtask.model.Project;
import com.epam.testtask.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService service;

    @Autowired
    public void setService(ProjectService service) {
        this.service = service;
    }

    //trims strings from form
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    //list all the projects
    @GetMapping("/list")
    public String getAll(Model model, HttpSession session) {
        List<Project> projects = service.findAll();
        model.addAttribute("projects", projects);
        session.setAttribute("allProjects", projects);
        return "projects/projects-list";
    }

    //show form for add new project
    @GetMapping("/addProjectForm")
    public String addProjectForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "projects/add-form";
    }

    //save new project from form
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute ("project") Project project, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "projects/add-form";
        }

        service.save(project);

        //post-redirect-get
        return "redirect:/projects/list";
    }

    //delete project by id
    @GetMapping("/delete")
    public String delete(@RequestParam("projectId") int projectId, Model model) {
        //success param is for js popup with alert if not deleted
        if (!service.deleteById(projectId)) {
            return "redirect:/projects/list?success=false";
        } else {
            return "redirect:/projects/list?success=true";
        }
    }
}
