package com.epam.testtask.controller;

import com.epam.testtask.model.Project;
import com.epam.testtask.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectRepository repository;

    @Autowired
    public void setRepository(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{projectId}")
    public Project get(@PathVariable int projectId) {
        //TODO: null check
        return repository.get(projectId);
    }

    @GetMapping("/")
    public List<Project> getAll() {
        return repository.getAll();
    }

    @PostMapping("/")
    public Project save(@RequestBody Project project) {
        //forcing to save new (not update)
        project.setId(0);
        return repository.save(project);
    }

    @PutMapping("/")
    public Project update(@RequestBody Project project) {
        return repository.save(project);
    }

    @DeleteMapping("/{projectId}")
    public boolean delete(@PathVariable int projectId) {
        //TODO: false - null
        return repository.delete(projectId);
    }
}
