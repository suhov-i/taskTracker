package com.epam.testtask.controller;

import com.epam.testtask.model.Project;
import com.epam.testtask.model.Task;
import com.epam.testtask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository repository;

    @Autowired
    public void setRepository(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{taskId}")
    public Task get(@PathVariable int taskId) {
        //TODO: null check
        return repository.get(taskId);
    }

    @GetMapping("/")
    public List<Task> getAll() {
        return repository.getAll();
    }

    @PostMapping("/")
    public Task save(@RequestBody Task task) {
        //forcing to save new (not update)
        task.setId(0);
        return repository.save(task);
    }

    @PutMapping("/")
    public Task update(@RequestBody Task task) {
        return repository.save(task);
    }

    @DeleteMapping("/{taskId}")
    public boolean delete(@PathVariable int taskId) {
        //TODO: false - null
        return repository.delete(taskId);
    }
}