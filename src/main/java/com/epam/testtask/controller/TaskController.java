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

    //trims strings from form
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    //list all the tasks
    @GetMapping("/list")
    public String getAll(Model model, HttpSession session, String userId, String projectId) {
        model.addAttribute("allUsers", session.getAttribute("allUsers"));
        model.addAttribute("allProjects", session.getAttribute("allProjects"));

        //getting tasks by user or by project if filtration was enabled
        if (userId == null && projectId == null) {
            model.addAttribute("tasks", service.findAll());
        } else if (userId != null) {
            model.addAttribute("tasks", service.findByUser(Integer.parseInt(userId)));
        } else
            model.addAttribute("tasks", service.findByProject(Integer.parseInt(projectId)));

        return "tasks/tasks-list";
    }

    //show form for add new task
    @GetMapping("/addTaskForm")
    public String addTaskForm(Model model, HttpSession session) {
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("allUsers", session.getAttribute("allUsers"));
        model.addAttribute("allProjects", session.getAttribute("allProjects"));
        return "tasks/add-form";
    }

    //save new task from form
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute ("task") Task task, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("allUsers", session.getAttribute("allUsers"));
            model.addAttribute("allProjects", session.getAttribute("allProjects"));
            return "tasks/add-form";
        }

        service.save(task);

        //post-redirect-get
        return "redirect:/tasks/list";
    }

    //delete task by id
    @GetMapping("/delete")
    public String delete(@RequestParam("taskId") int taskId) {
        service.deleteById(taskId);
        return "redirect:/tasks/list";
    }
}