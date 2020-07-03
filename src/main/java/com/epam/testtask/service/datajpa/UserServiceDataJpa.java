package com.epam.testtask.service.datajpa;

import com.epam.testtask.model.Project;
import com.epam.testtask.model.Task;
import com.epam.testtask.model.User;
import com.epam.testtask.repository.TaskRepository;
import com.epam.testtask.repository.UserRepository;
import com.epam.testtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDataJpa implements UserService {

    private UserRepository repository;

    /*
     * I know it's bad practice to have multiple repos in one service
     * (we need to check if user or project is in current task before deleting)
     * But I thought it's more OK like this than making additional facades and inject them in service
     */
    private TaskRepository taskRepository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public boolean deleteById(int id) {
        User user = findById(id);
        List<Task> tasks = taskRepository.findAll();

        //shall not delete if user has tasks
        for (Task task : tasks) {
            if (task.getUser().equals(user))
                return false;
        }

        repository.deleteById(id);
        return true;
    }
}
