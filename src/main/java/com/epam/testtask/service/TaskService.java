package com.epam.testtask.service;

import com.epam.testtask.model.Task;
import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(int id);

    void save(Task task);

    void deleteById(int id);

    List<Task> findByProject(int projectId);

    List<Task> findByUser(int userId);
}
