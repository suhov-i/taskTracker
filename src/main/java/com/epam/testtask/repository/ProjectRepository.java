package com.epam.testtask.repository;

import com.epam.testtask.model.Project;

import java.util.List;

public interface ProjectRepository {
    //TODO: use spring data jpa to remove repo???
    //TODO: findAllOrderByName...
    Project save(Project project);

    Project get(int id);

    boolean delete(int id);

    List<Project> getAll();
}
