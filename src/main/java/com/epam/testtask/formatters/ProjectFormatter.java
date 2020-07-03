package com.epam.testtask.formatters;

import com.epam.testtask.model.Project;
import com.epam.testtask.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProjectFormatter implements Formatter<Project> {

    private ProjectService projectService;

    @Autowired
    public void setUserService(ProjectService projectService) {
        this.projectService = projectService;
    }


    @Override
    public Project parse(String s, Locale locale) throws ParseException {
        int id = Integer.parseInt(s);
        return projectService.findById(id);
    }

    @Override
    public String print(Project project, Locale locale) {
        return project.getName();
    }
}

