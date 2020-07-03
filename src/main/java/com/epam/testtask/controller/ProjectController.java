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

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //trims string from form
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String getAll(Model model, HttpSession session) {
        List<Project> projects = service.findAll();
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
    public String save(@Valid @ModelAttribute ("project") Project project, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "projects/add-form";
        }

        //forcing to save new (not update)
        project.setId(0);
        service.save(project);

        //post-redirect-get
        return "redirect:/projects/list";
    }

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
