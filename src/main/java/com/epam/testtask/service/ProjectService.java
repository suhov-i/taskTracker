package com.epam.testtask.service;

import com.epam.testtask.model.Project;
import com.epam.testtask.model.User;
import com.epam.testtask.repository.ProjectRepository;
import com.epam.testtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private ProjectRepository repository;

    @Autowired
    public void setRepository(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project get(int id) {
        return repository.get(id);
    }
}
