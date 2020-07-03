package com.epam.testtask.controller;

import com.epam.testtask.model.Task;
import com.epam.testtask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private TaskService service;

    @Autowired
    public void setService(TaskService service) {
        this.service = service;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //trims string from form
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String getAll(Model model, HttpSession session, String userId, String projectId) {
        model.addAttribute("allUsers", session.getAttribute("allUsers"));
        model.addAttribute("allProjects", session.getAttribute("allProjects"));

        if (userId == null && projectId == null) {
            model.addAttribute("tasks", service.findAll());
        } else if (userId != null) {
            model.addAttribute("tasks", service.findByUser(Integer.parseInt(userId)));
        } else
            model.addAttribute("tasks", service.findByProject(Integer.parseInt(projectId)));

        return "tasks/tasks-list";
    }

    @GetMapping("/addTaskForm")
    public String addTaskForm(Model model, HttpSession session) {
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("allUsers", session.getAttribute("allUsers"));
        model.addAttribute("allProjects", session.getAttribute("allProjects"));
        return "tasks/add-form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute ("task") Task task, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("allUsers", session.getAttribute("allUsers"));
            model.addAttribute("allProjects", session.getAttribute("allProjects"));
            return "tasks/add-form";
        }

        //forcing to save new (not update)
        task.setId(0);
        service.save(task);

        //post-redirect-get
        return "redirect:/tasks/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("taskId") int taskId) {
        service.deleteById(taskId);
        return "redirect:/tasks/list";
    }
}