package com.epam.testtask.service.datajpa;

import com.epam.testtask.model.Task;
import com.epam.testtask.repository.TaskRepository;
import com.epam.testtask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceDataJpa implements TaskService {

    private TaskRepository repository;

    @Autowired
    public void setRepository(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Override
    public Task findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Task task) {
        repository.save(task);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Task> findByProject(int projectId) {
        return repository.findByProject(projectId);
    }

    @Override
    public List<Task> findByUser(int userId) {
        return repository.findByUser(userId);
    }
}
