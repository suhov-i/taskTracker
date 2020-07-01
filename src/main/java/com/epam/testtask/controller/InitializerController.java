package com.epam.testtask.controller;

import com.epam.testtask.repository.ProjectRepository;
import com.epam.testtask.repository.TaskRepository;
import com.epam.testtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//to init users and tasks lists
@Controller
@RequestMapping("/")
public class InitializerController {
    private ProjectRepository projectRepository;
    private UserRepository userRepository;

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String initializeLists(HttpSession session) {
        session.setAttribute("allUsers", userRepository.getAll());
        session.setAttribute("allProjects", projectRepository.getAll());
        return "redirect:/tasks/list";
    }
}
