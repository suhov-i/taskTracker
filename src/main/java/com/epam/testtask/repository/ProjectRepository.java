package com.epam.testtask.repository;

import com.epam.testtask.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
