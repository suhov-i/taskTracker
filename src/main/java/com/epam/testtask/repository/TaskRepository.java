package com.epam.testtask.repository;

import com.epam.testtask.model.Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);

    Task get(int id);

    boolean delete(int id);

    List<Task> getAll();
}
