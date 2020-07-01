package com.epam.testtask.controller;

import com.epam.testtask.model.Task;
import com.epam.testtask.model.User;
import com.epam.testtask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository repository;

    @Autowired
    public void setRepository(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("tasks", repository.getAll());
        return "tasks/tasks-list";
    }

    @GetMapping("/addTaskForm")
    public String addTaskForm(Model model, HttpSession session) {
        Task task = new Task();
        model.addAttribute("task", task);
//        model.addAttribute("projects", task);
        model.addAttribute("allUsers", session.getAttribute("allUsers"));
        model.addAttribute("allProjects", session.getAttribute("allProjects"));
        return "tasks/add-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ("task") Task task) {
        //forcing to save new (not update)
        task.setId(0);
        repository.save(task);

        //post-redirect-get
        return "redirect:/tasks/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("taskId") int taskId) {
        repository.delete(taskId);
        return "redirect:/tasks/list";
    }
}