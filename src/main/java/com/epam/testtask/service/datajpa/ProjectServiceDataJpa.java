package com.epam.testtask.service.datajpa;

import com.epam.testtask.model.Project;
import com.epam.testtask.model.Task;
import com.epam.testtask.repository.ProjectRepository;
import com.epam.testtask.repository.TaskRepository;
import com.epam.testtask.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceDataJpa implements ProjectService {

    private ProjectRepository repository;

    /*
     * I know it's bad practice to have multiple repos in one service
     * (we need to check if user or project is in current task before deleting)
     * But I thought it's more OK like this than making additional facades and inject them in service
     */
    private TaskRepository taskRepository;

    @Autowired
    public void setRepository(ProjectRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }

    @Override
    public Project findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Project project) {
        repository.save(project);
    }

    @Override
    public boolean deleteById(int id) {
        Project project = findById(id);
        List<Task> tasks = taskRepository.findAll();

        //shall not delete if project has tasks
        for (Task task : tasks) {
            if (task.getProject().equals(project))
                return false;
        }

        repository.deleteById(id);
        return true;
    }
}
