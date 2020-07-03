package com.epam.testtask.controller;

import com.epam.testtask.repository.ProjectRepository;
import com.epam.testtask.repository.TaskRepository;
import com.epam.testtask.repository.UserRepository;
import com.epam.testtask.service.ProjectService;
import com.epam.testtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//to init users and tasks lists
@Controller
@RequestMapping("/")
public class InitializerController {
    private ProjectService projectService;
    private UserService userService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String initializeLists(HttpSession session) {
        session.setAttribute("allUsers", userService.findAll());
        session.setAttribute("allProjects", projectService.findAll());
        return "redirect:/tasks/list";
    }
}
