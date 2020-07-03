package com.epam.testtask.service;

import com.epam.testtask.model.Project;
import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    Project findById(int id);

    void save(Project project);

    boolean deleteById(int id);
}
